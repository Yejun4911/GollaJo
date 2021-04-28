package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.Boards;
import com.gollajo.model.BoardsDAOImpl;

public class BoardListController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "index.jsp";
		String errMsg = "false";
		
		int page = Integer.parseInt(request.getParameter("page"));
		
		try {
			ArrayList<Boards> boardList = BoardsDAOImpl.getInstance().showBoardList(page);
			int boardCount = BoardsDAOImpl.getInstance().getBoardCount();
			request.setAttribute("boardList", boardList);
			request.setAttribute("pageCount", boardCount / 10 + 1);
			path = "board_list.jsp";
		} catch (SQLException e) {
			request.setAttribute("msg", errMsg);
		}
		
		return new ModelAndView(path);
	}

}
