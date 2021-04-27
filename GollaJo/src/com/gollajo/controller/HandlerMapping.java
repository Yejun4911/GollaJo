package com.gollajo.controller;
/*
 * Controller를 생성하는 공장...
 */
public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return factory;
	}
	
	// Component를 생성....command 하는 기능....factory본연의 역할
	public  Controller  createController(String command) {
		Controller controller = null;
		if (command.equals("idCheck.do")) {
			controller = new IdCheckController();
			System.out.println("<<<< IdCheckController Creating >>>>");
		} else if (command.equals("nicknameCheck.do")) {
			controller = new NicknameCheckController();
			System.out.println("<<<< NicknameCheckController Creating >>>>");
		} else if (command.equals("signUp.do")) {
			controller = new SignUpController();
			System.out.println("<<<< SignUpController Creating >>>>");
		} else if (command.equals("signIn.do")) {
			controller = new SignInController();
			System.out.println("<<<< SignInController Creating >>>>");
		} else if(command.equals("iogout.do")) {
			controller = new LogoutController();
		}
		
		return controller;
	}
	
}
