package com.gollajo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface FoodMenusDAO {
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	ArrayList<String> tasteMenu(String taste1, String tasts2, String tasts3) throws SQLException;
	ArrayList<String> situationMenu(String situation) throws SQLException;
	String randomMenu() throws SQLException;
	
}
