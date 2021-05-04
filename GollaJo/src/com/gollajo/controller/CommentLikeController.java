package com.gollajo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.CommentsDAOImpl;

public class CommentLikeController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		PrintWriter out = response.getWriter();
		
		String userIdx = request.getParameter("user_idx");
		String commentIdx = request.getParameter("comment_idx");
		try {
			boolean flag = CommentsDAOImpl.getInstance().isExistCommentLike(userIdx, commentIdx);
			if (flag) {
				out.print(false);
			} else {
				CommentsDAOImpl.getInstance().likeComment(userIdx, commentIdx);
				out.print(true);
			}
		} catch (SQLException e) {
			out.print(false);
		}
		
		return null;
	}

}