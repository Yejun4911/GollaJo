package com.gollajo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface BoardsDAO {
	
	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	ArrayList<BoardList> showBoardList(int page) throws SQLException;
	Boards showBoardByIdx(String boardIdx) throws SQLException;
	void registerBoard(String userIdx, String title, String question, String answer1, String answer2) throws SQLException;
	void deleteBoard(String boardIdx) throws SQLException;
	void updateBoard(String boardIdx, String title, String question, String answer1, String answer2) throws SQLException;
	int getBoardCount() throws SQLException;
	
}
