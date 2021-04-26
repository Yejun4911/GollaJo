package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.UsersDAOImpl;

public class SignUpController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "error.jsp";
		String errMsg = "Sign Up Fail...";
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");		
		String nickname = request.getParameter("nickname");		
		
		try {
			UsersDAOImpl.getInstance().signUp(id, pwd, nickname);
			path = "index.jsp";
		} catch (SQLException e) {
			request.setAttribute("msg", errMsg);
		}
		
		return new ModelAndView(path);
	}

}
