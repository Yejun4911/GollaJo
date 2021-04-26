package com.gollajo.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public static void main(String[] args)throws Exception {
	      DaoUnitTest test = new DaoUnitTest();
	      
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
	}

	
}
