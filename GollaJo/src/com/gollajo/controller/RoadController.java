package com.gollajo.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoadController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, Exception {
		String path="road_result.jsp";
		String[] arr = request.getParameterValues("place");
		double x=0.0;
		double y=0.0;
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
			int cnt=0;
			String[] arr2 = arr[i].split(",");
			try{
				for(String s : arr2) {
					if(cnt==0) {
						x+=Double.parseDouble(s);
						System.out.println(x);
					}
					else if(cnt==1) {
						y+=Double.parseDouble(s);
						System.out.println(y);
					}
					cnt++;	
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		double asize = arr.length;
		System.out.println(x);
		System.out.println(y);
		String px =""+(x/asize);
		String py=""+(y/asize);
		String point=px+","+py;
		
		System.out.println(point);
		request.setAttribute("x", px);
		request.setAttribute("y", py);
		
		return new ModelAndView(path);
	}

}
