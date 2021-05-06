package com.gollajo.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import util.DataSourceManager;

public class CommentsDAOImpl implements CommentsDAO {

	private DataSource ds;
	
	// Singleton
	private static CommentsDAOImpl dao = new CommentsDAOImpl();
	private CommentsDAOImpl() {
		ds = DataSourceManager.getInstance().getConnection();
	}
	public static CommentsDAOImpl getInstance() {
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
	public ArrayList<CommentAndLikes> showCommentList(String boardIdx) throws SQLException {
		ArrayList<CommentAndLikes> commentList = new ArrayList<CommentAndLikes>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String query = "SELECT comments.comment_idx AS comment_idx, users.user_idx AS user_idx, nickname, comment, register_datetime, modify_datetime, COUNT(comment_likes.user_idx) AS likes"
					+ "    FROM comments"
					+ "    LEFT JOIN users ON comments.user_idx=users.user_idx"
					+ "    LEFT JOIN comment_likes ON comments.comment_idx=comment_likes.comment_idx"
				    + "    WHERE board_idx=?"
					+ "    GROUP BY comment_idx"
					+ "    ORDER BY comment_idx DESC";
			ps = conn.prepareStatement(query);
			ps.setString(1, boardIdx);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				commentList.add(new CommentAndLikes(
						rs.getInt("comment_idx"),
						rs.getInt("user_idx"),
						rs.getString("nickname"),
						rs.getString("comment"),
						rs.getString("register_datetime"),
						rs.getString("modify_datetime"),
						rs.getInt("likes")
						));
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return commentList;
	}
	
	@Override
	public CommentAndLikes showCommentLikeByIdx(int commentIdx) throws SQLException {
		CommentAndLikes comment = null;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			
			String query = "SELECT comments.comment_idx AS comment_idx, users.user_idx AS user_idx, nickname, comment, register_datetime, modify_datetime, COUNT(comment_likes.user_idx) AS likes"
					+ "    FROM comments"
					+ "    LEFT JOIN users ON comments.user_idx=users.user_idx"
					+ "    LEFT JOIN comment_likes ON comments.comment_idx=comment_likes.comment_idx"
				    + "    WHERE comments.comment_idx=?"
					+ "    GROUP BY comment_idx"
					+ "    ORDER BY comment_idx DESC";
			ps = conn.prepareStatement(query);
			ps.setInt(1, commentIdx);
			
			rs = ps.executeQuery();
			if (rs.next()) {
				comment = new CommentAndLikes(
						rs.getInt("comment_idx"),
						rs.getInt("user_idx"),
						rs.getString("nickname"),
						rs.getString("comment"),
						rs.getString("register_datetime"),
						rs.getString("modify_datetime"),
						rs.getInt("likes")
						);
			}
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return comment;
	}

	@Override
	public void registerComment(String userIdx, String boardIdx, String comment) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO comments"
					+ "(user_idx, board_idx, comment, register_datetime, modify_datetime)"
					+ "VALUES (?, ?, ?, NOW(), NOW());";
			ps = conn.prepareStatement(query);
			ps.setString(1, userIdx);
			ps.setString(2, boardIdx);
			ps.setString(3, comment);
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		} catch(SQLException e) {
			
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public int getLastCommentIdx() throws SQLException {
		int lastCommentIdx = 0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT comment_idx FROM comments ORDER BY comment_idx DESC LIMIT 1";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			if (rs.next()) lastCommentIdx = rs.getInt("comment_idx");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return lastCommentIdx;
	}
	
	@Override
	public void updateComment(String commentIdx, String comment) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "UPDATE comments SET comment=? WHERE comment_idx=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, comment);
			ps.setString(2, commentIdx);
			
			System.out.println(ps.executeUpdate()+" row UPDATE OK!!");
		} catch(SQLException e) {
			
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public void deleteComment(String commentIdx) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "DELETE FROM comments WHERE comment_idx=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, commentIdx);
			
			System.out.println(ps.executeUpdate()+" row DELETE OK!!");
		} catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeAll(ps, conn);
		}
	}

	@Override
	public boolean isExistCommentLike(String userIdx, String commentIdx) throws SQLException {
		boolean flag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			String query = "SELECT comment_like_idx, user_idx, comment_idx\r\n"
					+ "FROM comment_likes\r\n"
					+ "WHERE user_idx=? AND comment_idx=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, userIdx);
			ps.setString(2, commentIdx);
			
			rs = ps.executeQuery();
			flag = rs.next();
		} finally {
			closeAll(rs, ps, conn);
		}
		
		return flag;
	}
	
	@Override
	public void likeComment(String userIdx, String commentIdx) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnection();
			String query = "INSERT INTO comment_likes (user_idx, comment_idx) VALUES (?, ?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, userIdx);
			ps.setString(2, commentIdx);
			
			System.out.println(ps.executeUpdate()+" row INSERT OK!!");
		} catch(SQLException e) {
			
		}finally {
			closeAll(ps, conn);
		}
	}

}
