package com.gollajo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.BoardsDAOImpl;

public class BoardVoteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		PrintWriter out = response.getWriter();

		String userIdx = request.getParameter("user_idx");
		String boardIdx = request.getParameter("board_idx");
		String vote = request.getParameter("vote");
		System.out.println(vote);
		try {
			if (BoardsDAOImpl.getInstance().isExistVote(userIdx, boardIdx)) {
				out.print(false);
				return null;
			}
			BoardsDAOImpl.getInstance().setAnswer(userIdx, boardIdx, vote);
			out.print(true);
		} catch(SQLException e) {
			
		}
		
		return null;
	}

}
