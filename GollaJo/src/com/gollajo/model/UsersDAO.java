package com.gollajo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UsersDAO {
	
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	boolean isExistId(String id) throws SQLException;
	boolean isExistNickname(String nickname) throws SQLException;
	void signUp(String id, String pwd, String nickname) throws SQLException;
	Users signIn(String id, String pwd) throws SQLException;
	
}
