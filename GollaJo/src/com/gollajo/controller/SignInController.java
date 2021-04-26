package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gollajo.model.Users;
import com.gollajo.model.UsersDAOImpl;

public class SignInController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "error.jsp";
		String errMsg = "Sign In Fail...";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		try {
			Users rvo = UsersDAOImpl.getInstance().signIn(id, pwd);
			
			HttpSession session = request.getSession();
			
			if (rvo != null) {
				session.setAttribute("vo", rvo);
				path = "index.jsp";
			}
		} catch (SQLException e) {
			request.setAttribute("msg", errMsg);
		}
		
		return new ModelAndView(path);
	}

}
