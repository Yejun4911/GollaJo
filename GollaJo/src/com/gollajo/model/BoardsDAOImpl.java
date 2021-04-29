package com.gollajo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import util.DataSourceManager;

public class BoardsDAOImpl implements BoardsDAO {

	private DataSource ds;
	
	// Singleton
	private static BoardsDAOImpl dao = new BoardsDAOImpl();
	private BoardsDAOImpl() {
		ds = DataSourceManager.getInstance().getConnection();
	}
	public static BoardsDAOImpl getInstance() {
		return dao;
	}
	
	@Override
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공....");
		return ds.getConnection();
	}

	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if (ps != null) ps.close();		
		if (conn != null) conn.close();
	}

	@Override
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		if (rs != null)	rs.close();
		closeAll(ps, conn);	
	}

	@Override
	public ArrayList<BoardList> showBoardList(int page) throws SQLException {
		ArrayList<BoardList> boardList = new ArrayList<BoardList>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String query = "SELECT board_idx, title, nickname, register_datetime, view_count FROM boards LEFT JOIN users ON boards.user_idx=users.user_idx ORDER BY board_idx DESC LIMIT ?, 10";
			ps = conn.prepareStatement(query);
			ps.setInt(1, (page - 1) * 10);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				boardList.add(new BoardList(
						rs.getInt("board_idx"),
						rs.getString("title"),
						rs.getString("nickname"),
						rs.getString("register_datetime"),
						rs.getInt("view_count")
						));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return boardList;
	}
	
	@Override
	public void increaseViewCount(String boardIdx) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String query = "UPDATE boards SET view_count=view_count+1 WHERE board_idx=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, boardIdx);
			
			System.out.println(ps.executeUpdate()+" row UPDATE OK!!");
		} finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public Boards showBoardByIdx(String boardIdx) throws SQLException {
		Boards board = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "SELECT board_idx, user_idx, title, question, answer1, answer2, view_count, register_datetime, modify_datetime FROM boards WHERE board_idx=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, boardIdx);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				board = new Boards(
						rs.getInt("board_idx"),
						rs.getInt("user_idx"),
						rs.getString("title"),
						rs.getString("question"),
						rs.getString("answer1"),
						rs.getString("answer2"),
						rs.getInt("view_count"),
						rs.getString("register_datetime"),
						rs.getString("modify_datetime")
						);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return board;
	}

	@Override
	public void registerBoard(String userIdx, String title, String question, String answer1, String answer2)
			throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO boards (user_idx, title, question, answer1, answer2, register_datetime, modify_datetime) VALUES (?, ?, ?, ?, ?, now(), now())";
			ps = conn.prepareStatement(query);
			ps.setString(1, userIdx);
			ps.setString(2, title);
			ps.setString(3, question);
			ps.setString(4, answer1);
			ps.setString(5, answer2);
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteBoard(String boardIdx) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String query = "DELETE FROM boards WHERE board_idx=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, boardIdx);
			
			System.out.println(ps.executeUpdate()+" row DELETE OK!!");
		} finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void updateBoard(String boardIdx, String title, String question, String answer1, String answer2)
			throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = getConnection();
			String query = "UPDATE boards SET title=?, question=?, answer1=?, answer2=?, modify_datetime=now() WHERE board_idx=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, question);
			ps.setString(3, answer1);
			ps.setString(4, answer2);
			ps.setString(5, boardIdx);
			
			System.out.println(ps.executeUpdate()+" row UPDATE OK!!");
		} finally {
			closeAll(ps, conn);
		}
	}
	
	@Override
	public int getBoardCount() 
			throws SQLException {
		int boardCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT COUNT(board_idx) AS board_count FROM boards";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			if (rs.next()) boardCount = rs.getInt("board_count");
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return boardCount;
	}

	@Override
	public int getLastBoardIdx()
			throws SQLException {
		int lastBoardIdx = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT board_idx FROM boards ORDER BY board_idx DESC LIMIT 1";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			if (rs.next()) lastBoardIdx = rs.getInt("board_idx");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return lastBoardIdx;
	}

	@Override
	public int getAnswer1(String boardIdx)
			throws SQLException {
		int answer1 = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT COUNT(vote) AS vote_count FROM board_votes WHERE board_idx=? AND vote=1";
			ps = conn.prepareStatement(query);
			ps.setString(1, boardIdx);
			
			rs = ps.executeQuery();
			if (rs.next()) answer1 = rs.getInt("vote_count");
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return answer1;
	}
	

	@Override
	public int getAnswer2(String boardIdx)
			throws SQLException {
		int answer2 = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT COUNT(vote) AS vote_count FROM board_votes WHERE board_idx=? AND vote=1";
			ps = conn.prepareStatement(query);
			ps.setString(1, boardIdx);
			
			rs = ps.executeQuery();
			if (rs.next()) answer2 = rs.getInt("vote_count");
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return answer2;
	}
	
}
