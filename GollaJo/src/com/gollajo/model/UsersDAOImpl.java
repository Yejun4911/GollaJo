package com.gollajo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import util.DataSourceManager;

public class UsersDAOImpl implements UsersDAO {

	private DataSource ds;
	
	// Singleton
	private static UsersDAOImpl dao = new UsersDAOImpl();
	private UsersDAOImpl() {
		ds = DataSourceManager.getInstance().getConnection();
	}
	public static UsersDAOImpl getInstance() {
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

	@Override
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

	@Override
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
		}catch (SQLException e){
			e.printStackTrace();
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
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

}
