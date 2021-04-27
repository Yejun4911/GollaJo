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
	public ArrayList<Boards> showBoardList() throws SQLException {
		ArrayList<Boards> boardList = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT board_idx, user_idx, title, question, answer1, answer2, view_count, register_datetime, modify_datetime FROM boards";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				boardList.add(new Boards(
						rs.getInt("board_idx"),
						rs.getInt("user_idx"),
						rs.getString("title"),
						rs.getString("question"),
						rs.getString("answer1"),
						rs.getString("answer2"),
						rs.getInt("view_count"),
						rs.getString("register_datetime"),
						rs.getString("modify_datetime")
						));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return boardList;
	}

	@Override
	public Boards showBoardByIdx(String board_idx) throws SQLException {
		Boards board = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "SELECT board_idx, user_idx, title, question, answer1, answer2, view_count, register_datetime, modify_datetime FROM boards WHERE board_idx=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, board_idx);
			
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
	public void registerBoard(int userIdx, String title, String question, String answer1, String answer2)
			throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(String board_idx) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateBoard(String board_idx, String title, String question, String answer1, String answer2)
			throws SQLException {
		// TODO Auto-generated method stub

	}

}
