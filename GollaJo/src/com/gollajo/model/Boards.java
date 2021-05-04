package com.gollajo.model;

public class Boards {
	private int boardIdx;
	private int userIdx;
	private String nickname;
	private String title;
	private String question;
	private String answer1;
	private String answer2;
	private int viewCount;
	private String registerDatetime;
	private String modifyDatetime;
	public Boards(int boardIdx, int userIdx, String nickname, String title, String question, String answer1,
			String answer2, int viewCount, String registerDatetime, String modifyDatetime) {
		super();
		this.boardIdx = boardIdx;
		this.userIdx = userIdx;
		this.nickname = nickname;
		this.title = title;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.viewCount = viewCount;
		this.registerDatetime = registerDatetime;
		this.modifyDatetime = modifyDatetime;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getRegisterDatetime() {
		return registerDatetime;
	}
	public void setRegisterDatetime(String registerDatetime) {
		this.registerDatetime = registerDatetime;
	}
	public String getModifyDatetime() {
		return modifyDatetime;
	}
	public void setModifyDatetime(String modifyDatetime) {
		this.modifyDatetime = modifyDatetime;
	}
	@Override
	public String toString() {
		return "Boards [boardIdx=" + boardIdx + ", userIdx=" + userIdx + ", nickname=" + nickname + ", title=" + title
				+ ", question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2 + ", viewCount="
				+ viewCount + ", registerDatetime=" + registerDatetime + ", modifyDatetime=" + modifyDatetime + "]";
	}
	
}
