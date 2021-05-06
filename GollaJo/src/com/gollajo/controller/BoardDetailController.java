package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.Boards;
import com.gollajo.model.BoardsDAOImpl;
import com.gollajo.model.CommentAndLikes;
import com.gollajo.model.CommentsDAOImpl;
import com.gollajo.model.UsersDAOImpl;

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
			int vote1 = BoardsDAOImpl.getInstance().getAnswer1(boardIdx);
			int vote2 = BoardsDAOImpl.getInstance().getAnswer2(boardIdx);
			if (board != null) {
				request.setAttribute("board", board);
				request.setAttribute("vote1", vote1);
				request.setAttribute("vote2", vote2);
				path = "board/board_detail.jsp";
			}else {
				request.setAttribute("msg", errMsg);
			}
			
			ArrayList<CommentAndLikes> commentList = CommentsDAOImpl.getInstance().showCommentList(boardIdx);
			request.setAttribute("commentList", commentList);
		} catch (SQLException e) {
			request.setAttribute("msg", errMsg);
		}
		
		return new ModelAndView(path);
	}

}
