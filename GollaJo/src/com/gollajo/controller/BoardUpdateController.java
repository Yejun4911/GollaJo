package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.BoardsDAOImpl;
import com.gollajo.model.UsersDAOImpl;

public class BoardUpdateController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "boardWrite.do";
		String errMsg = "false";
		
		String boardIdx = request.getParameter("board_idx");
		String title = request.getParameter("title");		
		String question = request.getParameter("question");		
		String answer1 = request.getParameter("answer1");		
		String answer2 = request.getParameter("answer2");
		System.out.println(boardIdx + ", ");
		try {
			BoardsDAOImpl.getInstance().updateBoard(boardIdx, title, question, answer1, answer2);
			path = "boardDetail.do?board_idx=" + boardIdx;
		} catch (SQLException e) {
			request.setAttribute("msg", errMsg);
		}
		
		return new ModelAndView(path);
	}

}
