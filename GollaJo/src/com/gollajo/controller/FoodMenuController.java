package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.UsersDAOImpl;

public class FoodMenuController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "error.jsp";
		String errMsg = "Sign Up Fail...";
		
		String taste1 = request.getParameter("taste1");
		String taste2 = request.getParameter("taste2");
		String taste3 = request.getParameter("taste3");	
		System.out.println(taste1+" "+taste2+ " "+taste3);
		
		try {
			
		} catch (SQLException e) {
		
		}
		
		return new ModelAndView(path);
	}


}
