package com.gollajo.model;

public class Users {
	private int userIdx;
	private String id;
	private String pwd;
	private String nickname;
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Users(int userIdx, String id, String pwd, String nickname) {
		super();
		this.userIdx = userIdx;
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Users [userIdx=" + userIdx + ", id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + "]";
	}
	
	
}
