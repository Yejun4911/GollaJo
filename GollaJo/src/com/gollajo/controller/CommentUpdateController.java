package com.gollajo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.CommentsDAOImpl;

public class CommentUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		PrintWriter out = response.getWriter();
		
		String commentIdx = request.getParameter("comment_idx");
		String comment = request.getParameter("comment");
		try {
			CommentsDAOImpl.getInstance().updateComment(commentIdx, comment);
			out.print(true);
		} catch (SQLException e) {
			out.print(false);
		}
		
		return null;
	}

}
