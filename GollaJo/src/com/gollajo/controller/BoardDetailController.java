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
		
		String boardIdx = request.getParameter("board_idx");
		
		try {
			BoardsDAOImpl.getInstance().increaseViewCount(boardIdx);
			Boards board = BoardsDAOImpl.getInstance().showBoardByIdx(boardIdx);
			int answer1 = BoardsDAOImpl.getInstance().getAnswer1(boardIdx);
			int answer2 = BoardsDAOImpl.getInstance().getAnswer2(boardIdx);
			
			if (board != null) {
				request.setAttribute("board", board);
				request.setAttribute("answer1", answer1);
				request.setAttribute("answer2", answer2);
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
