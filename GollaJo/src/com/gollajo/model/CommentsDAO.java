package com.gollajo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface CommentsDAO {

	Connection getConnection() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn) throws SQLException;
	void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException;
	
	ArrayList<CommentAndLikes> showCommentList(String boardIdx) throws SQLException;
	CommentAndLikes showCommentLikeByIdx(String commentIdx) throws SQLException;
	void registerComment(String userIdx, String boardIdx, String comment) throws SQLException;
	void updateComment(String commentIdx, String comment) throws SQLException;
	void deleteComment(String commentIdx) throws SQLException;
	void likeComment(String userIdx, String commentIdx) throws SQLException;
	
}