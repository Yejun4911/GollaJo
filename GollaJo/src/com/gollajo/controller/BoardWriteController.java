package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.Boards;
import com.gollajo.model.BoardsDAOImpl;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "boardDetail.do";
		String errMsg = "false";
		
		String boardIdx = request.getParameter("board_idx");
		
		try {
			Boards board = BoardsDAOImpl.getInstance().showBoardByIdx(boardIdx);
			
			if (board != null) {
				request.setAttribute("board", board);
				path = "board/board_write.jsp";
			}else {
				request.setAttribute("msg", errMsg);
			}
		} catch (SQLException e) {
			request.setAttribute("msg", errMsg);
		}
		
		return new ModelAndView(path);
	}

}
