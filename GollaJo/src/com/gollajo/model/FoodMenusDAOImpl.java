package com.gollajo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import util.DataSourceManager;

public class FoodMenusDAOImpl implements FoodMenusDAO{
	private DataSource ds;
	
	private static FoodMenusDAOImpl dao = new FoodMenusDAOImpl();
	private FoodMenusDAOImpl() {
		ds = DataSourceManager.getInstance().getConnection();
	}
	
	public static FoodMenusDAOImpl getInstance() {
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
	public ArrayList<String> tasteMenu(String taste1, String tasts2, String tasts3) throws SQLException {
		ArrayList<Boards> foodList = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select*from ";
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
		
		return foodList;
	}

	@Override
	public ArrayList<String> situationMenu(String situation) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String randomMenu() throws SQLException {
		String name=null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select name from foods order by rand() limit 1";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			if(rs.next()) {
				name=rs.getString("name");
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return name;
	}

}
