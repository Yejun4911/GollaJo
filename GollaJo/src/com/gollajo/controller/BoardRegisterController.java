package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.BoardsDAOImpl;

public class BoardRegisterController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "board_write.jsp";
		String errMsg = "false";
		
		String userIdx = request.getParameter("user_idx");
		String title = request.getParameter("title");		
		String question = request.getParameter("question");		
		String answer1 = request.getParameter("answer1");		
		String answer2 = request.getParameter("answer2");
		
		try {
			BoardsDAOImpl.getInstance().registerBoard(userIdx, title, question, answer1, answer2);
			int lastBoardIdx = BoardsDAOImpl.getInstance().getLastBoardIdx();
			path = "boardDetail.do?board_idx=" + lastBoardIdx;
		} catch (SQLException e) {
			request.setAttribute("msg", errMsg);
		}
		
		return new ModelAndView(path, true);
	}

}
