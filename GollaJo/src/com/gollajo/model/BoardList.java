package com.gollajo.model;

public class BoardList { // board_list.jsp에서 쓰는 vo
	
	private int boardIdx;
	private String title;
	private String nickname;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public BoardList(int boardIdx, String title, String nickname, String registerDatetime, int viewCount) {
		super();
		this.boardIdx = boardIdx;
		this.title = title;
		this.nickname = nickname;
		this.registerDatetime = registerDatetime;
		this.viewCount = viewCount;
	}
	@Override
	public String toString() {
		return "BoardList [boardIdx=" + boardIdx + ", title=" + title + ", nickname=" + nickname + ", registerDatetime="
				+ registerDatetime + ", viewCount=" + viewCount + "]";
	}
	
}
