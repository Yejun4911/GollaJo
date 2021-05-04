package com.gollajo.model;

public class CommentAndLikes {

	private int commentIdx;
	private int userIdx;
	private String nickname;
	private String comment;
	private String registerDatetime;
	private String modifyDatetime;
	private int likes;
	
	public CommentAndLikes(int commentIdx, int userIdx, String nickname, String comment, String registerDatetime,
			String modifyDatetime, int likes) {
		super();
		this.commentIdx = commentIdx;
		this.userIdx = userIdx;
		this.nickname = nickname;
		this.comment = comment;
		this.registerDatetime = registerDatetime;
		this.modifyDatetime = modifyDatetime;
		this.likes = likes;
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
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
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	@Override
	public String toString() {
		return "CommentAndLikes [commentIdx=" + commentIdx + ", userIdx=" + userIdx + ", nickname=" + nickname
				+ ", comment=" + comment + ", registerDatetime=" + registerDatetime + ", modifyDatetime="
				+ modifyDatetime + ", likes=" + likes + "]";
	}

}
