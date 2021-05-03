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
		} else if (command.equals("logout.do")) {
			controller = new LogoutController();
		} else if (command.equals("boardList.do")) {
			controller = new BoardListController();
		} else if (command.equals("boardDetail.do")) {
			controller = new BoardDetailController();
		} else if (command.equals("boardWrite.do")) {
			controller = new BoardWriteController();
		} else if (command.equals("boardUpdate.do")) {
			controller = new BoardUpdateController();
		} else if (command.equals("boardRegister.do")) {
			controller = new BoardRegisterController();
		} else if (command.equals("boardDelete.do")) {
			controller = new BoardDeleteController();
		} else if (command.equals("food.do")) {
			controller = new FoodMenuController();
		} else if (command.equals("boardVote.do")) {
			controller = new BoardVoteController();
		} else if (command.equals("commentWrite.do")) {
			controller = new CommentWriteController();
		} 
		
		return controller;
	}
	
}
