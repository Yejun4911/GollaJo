package com.gollajo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.gollajo.model.Boards;
import com.gollajo.model.Users;

import config.ServerInfo;
//public class DaoUnitTest implements ItemDaoTemplate{	
public class DaoUnitTest {
	DaoUnitTest(){
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("드라이버 로딩 성공...");
			
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패...");
		}
	}
	
	public Connection getConnection() throws SQLException {
		System.out.println("디비연결 성공....");
		return DriverManager.getConnection(ServerInfo.URL,ServerInfo.USER, ServerInfo.PASS);
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException{
		if(ps!=null) ps.close();		
		if(conn != null) conn.close();
	}
	
	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException{		
		if(rs != null)	rs.close();
		closeAll(ps, conn);		
	}
	
	public boolean isExistId(String id) throws SQLException {
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT id FROM users WHERE id=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			flag = rs.next();
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return flag;
	}

	public boolean isExistNickname(String nickname) throws SQLException {
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT nickname FROM users WHERE nickname=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, nickname);
			
			rs = ps.executeQuery();
			flag = rs.next();
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return flag;
	}

	public void signUp(String id, String pwd, String nickname) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO users (id, pwd, nickname) VALUES (?, ?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ps.setString(3, nickname);

			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		} finally {
			closeAll(ps, conn);
		}
	}

	public Users signIn(String id, String pwd) throws SQLException {
		Users user = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT user_idx, id, pwd, nickname FROM users WHERE id=? AND pwd=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new Users(
						rs.getInt("user_idx"),
						id,
						pwd,
						rs.getString("nickname")
						);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return user;
	}
	
//	public static void main(String[] args)throws Exception {
//	      DaoUnitTest test = new DaoUnitTest();
//	      
//	      System.out.println("=============================");
//	      boolean flag = test.isExistId("aaaa");
//	      System.out.println(flag);
//	      
//	      System.out.println("=============================");
//	      boolean flag = test.isExistNickname("a5");
//	      System.out.println(flag);
//	      
//	      System.out.println("=============================");
//	      test.signUp("cccc", "9101", "c4");
//	      
//	      System.out.println("=============================");
//	      Users user = test.signIn("cccc", "9101");
//	      System.out.println(user);
//	}

	public ArrayList<Boards> showBoardList(int page) throws SQLException {
		ArrayList<Boards> boardList = new ArrayList<Boards>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT board_idx, user_idx, title, question, answer1, answer2, view_count, register_datetime, modify_datetime FROM boards LIMIT ?, 10";
			ps = conn.prepareStatement(query);
			ps.setInt(1, (page - 1) * 10);
			
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
		} finally {
			closeAll(ps, conn);
		}
	}

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
	
	public int getBoardCount() 
			throws SQLException {
		int boardCount = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT COUNT(board_idx) AS board_count FROM boards;";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			if (rs.next()) boardCount = rs.getInt("board_count");
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return boardCount;
	}
	
//	public static void main(String[] args)throws Exception {
//		DaoUnitTest test = new DaoUnitTest();
//		
//		ArrayList<Boards> list = test.showBoardList(1);
//		System.out.println(list);
//		
//		Boards board = test.showBoardByIdx("1");
//		System.out.println(board);
//		
//		test.registerBoard("2", "Title", "Question", "answer1", "answer2");
//		ArrayList<Boards> list2 = test.showBoardList(2);
//		System.out.println(list2);
//		
//		test.deleteBoard("1");
//		ArrayList<Boards> list3 = test.showBoardList(1);
//		System.out.println(list3);
//		
//		test.updateBoard("2", "목제", "용내", "1답응", "2답응");
//		Boards board2 = test.showBoardByIdx("2");
//		System.out.println(board2);
//		int boardCount = test.getBoardCount();
//		System.out.println(boardCount);
//	}
}
