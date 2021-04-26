package com.gollajo.model;

import java.util.Date;

public class Boards {
	private int boardIdx;
	private int userIdx;
	private String title;
	private String question;
	private String answer1;
	private String answer2;
	private Date registerDate;
	private Date modifyDate;
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
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Boards(int boardIdx, int userIdx, String title, String question, String answer1, String answer2,
			Date registerDate, Date modifyDate) {
		super();
		this.boardIdx = boardIdx;
		this.userIdx = userIdx;
		this.title = title;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.registerDate = registerDate;
		this.modifyDate = modifyDate;
	}
	@Override
	public String toString() {
		return "Boards [boardIdx=" + boardIdx + ", userIdx=" + userIdx + ", title=" + title + ", question=" + question
				+ ", answer1=" + answer1 + ", answer2=" + answer2 + ", registerDate=" + registerDate + ", modifyDate="
				+ modifyDate + "]";
	}

	
	
	
}
