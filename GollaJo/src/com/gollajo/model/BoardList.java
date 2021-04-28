package com.gollajo.model;

public class BoardList { // board_list.jsp에서 쓰는 vo
	
	private int boardIdx;
	private String title;
	private String userName;
	private String registerDatetime;
	private int viewCount;
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRegisterDatetime() {
		return registerDatetime;
	}
	public void setRegisterDatetime(String registerDatetime) {
		this.registerDatetime = registerDatetime;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public BoardList(int boardIdx, String title, String userName, String registerDatetime, int viewCount) {
		super();
		this.boardIdx = boardIdx;
		this.title = title;
		this.userName = userName;
		this.registerDatetime = registerDatetime;
		this.viewCount = viewCount;
	}
	@Override
	public String toString() {
		return "BoardList [boardIdx=" + boardIdx + ", title=" + title + ", userName=" + userName + ", registerDatetime="
				+ registerDatetime + ", viewCount=" + viewCount + "]";
	}
	
}
