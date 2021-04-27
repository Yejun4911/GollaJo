package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.Boards;
import com.gollajo.model.BoardsDAOImpl;

public class BoardDetailController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "boardList.do";
		String errMsg = "false";
		
		String board_idx = request.getParameter("board_idx");
		
		try {
			Boards board = BoardsDAOImpl.getInstance().showBoardByIdx(board_idx);
			
			if (board != null) {
				request.setAttribute("board", board);
				path = "board_detail.jsp";
			}else {
				request.setAttribute("msg", errMsg);
			}
		} catch (SQLException e) {
			request.setAttribute("msg", errMsg);
		}
		
		return new ModelAndView(path);
	}

}
