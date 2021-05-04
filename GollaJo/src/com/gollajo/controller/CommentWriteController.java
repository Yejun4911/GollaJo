package com.gollajo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.Boards;
import com.gollajo.model.BoardsDAOImpl;
import com.gollajo.model.CommentAndLikes;
import com.gollajo.model.CommentsDAOImpl;
import com.google.gson.Gson;

public class CommentWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		PrintWriter out = response.getWriter();
		
		String userIdx = request.getParameter("user_idx");
		String boardIdx = request.getParameter("board_idx");
		String comment = request.getParameter("comment");
		
		try {
			CommentsDAOImpl.getInstance().registerComment(userIdx, boardIdx, comment);
			
			CommentAndLikes cal = CommentsDAOImpl.getInstance().showCommentLikeByIdx(CommentsDAOImpl.getInstance().getLastCommentIdx());
			Gson gson = new Gson();
			String calJson = gson.toJson(cal);
			out.print(calJson);
		} catch (SQLException e) {
			
		}
		
		return null;
	}

}
