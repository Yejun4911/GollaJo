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
ArrayList<String> foodList = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select f.name, count(*) from foods f, foods_tastes fc, tastes c where fc.food_idx=f.food_idx and fc.taste_idx = c.taste_idx and taste in(?,?,?) group by f.name having count(*) >=2 order by count(*) desc;";
			ps = conn.prepareStatement(query);
			ps.setString(1, taste1);
			ps.setString(2, tasts2);
			ps.setString(3, tasts3);
			rs = ps.executeQuery();
			while (rs.next()) {
				foodList.add(rs.getString("name"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("실패");
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return foodList;
	}

	@Override
	public ArrayList<String> situationMenu(String situation) throws SQLException {
		ArrayList<String> foodList = new ArrayList<String>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String query = "select f.name  from foods f, foods_cases fc, cases c where fc.food_idx=f.food_idx and fc.case_idx=c.case_idx and c.case=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, situation);
			rs = ps.executeQuery();
			while (rs.next()) {
				foodList.add(rs.getString("name"));
				System.out.println(rs.getString("name"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			System.out.println("실패");
		}finally {
			closeAll(rs, ps, conn);
		}
		
		return foodList;
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
