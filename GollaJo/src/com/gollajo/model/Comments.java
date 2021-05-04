package com.gollajo.model;

import java.util.Date;

public class Comments {
	private int commentIdx;
	private int userIdx;
	private int boardIdx;
	private String comment;
	private Date registerDate;
	private Date modifyDate;
	
	
	public Comments(int commentIdx, int userIdx, int boardIdx, String comment, Date registerDate, Date modifyDate) {
		super();
		this.commentIdx = commentIdx;
		this.userIdx = userIdx;
		this.boardIdx = boardIdx;
		this.comment = comment;
		this.registerDate = registerDate;
		this.modifyDate = modifyDate;
	}
	public int getCommentIdx() {
		return commentIdx;
	}
	public void setCommentIdx(int commentIdx) {
		this.commentIdx = commentIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getBoardIdx() {
		return boardIdx;
	}
	public void setBoardIdx(int boardIdx) {
		this.boardIdx = boardIdx;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	@Override
	public String toString() {
		return "Comments [commentIdx=" + commentIdx + ", userIdx=" + userIdx + ", boardIdx=" + boardIdx + ", comment="
				+ comment + ", registerDate=" + registerDate + ", modifyDate=" + modifyDate + "]";
	}
	
	
	
}
