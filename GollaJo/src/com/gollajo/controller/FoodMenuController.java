package com.gollajo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gollajo.model.FoodMenusDAOImpl;

public class FoodMenuController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path = "";
		
		String choice = request.getParameter("choice");
		System.out.println("choice : "+choice);
		
		if(choice.equals("1")) {
			String taste1 = request.getParameter("taste1");
			String taste2 = request.getParameter("taste2");
			String taste3 = request.getParameter("taste3");	
			System.out.println(taste1+" "+taste2+ " "+taste3);
			try {
				ArrayList<String> list = FoodMenusDAOImpl.getInstance().tasteMenu(taste1, taste2, taste3);
				request.setAttribute("list",list);
			}catch(SQLException e) {
				
			}
			path="taste_result.jsp";
			
		}else if(choice.equals("2")) {
			String sitNum = request.getParameter("situation");
			System.out.println("sitNum : "+sitNum);
			try {
				ArrayList<String> list = FoodMenusDAOImpl.getInstance().situationMenu(sitNum);
				request.setAttribute("list",list);
			}catch(SQLException e) {
				
			}
			
			
			path="sit_result.jsp";
			
			
		}
		else if(choice.equals("3")) {
			String name = FoodMenusDAOImpl.getInstance().randomMenu();
			request.setAttribute("name", name);
			path="random_result.jsp";
		}
		
	
		
		return new ModelAndView(path);
	}


}
