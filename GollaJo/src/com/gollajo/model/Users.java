package com.gollajo.model;

public class Users {
	private int user_idx;
	private String id;
	private String pwd;
	private String nickname;
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
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
	public Users(int user_idx, String id, String pwd, String nickname) {
		super();
		this.user_idx = user_idx;
		this.id = id;
		this.pwd = pwd;
		this.nickname = nickname;
	}
	@Override
	public String toString() {
		return "Users [user_idx=" + user_idx + ", id=" + id + ", pwd=" + pwd + ", nickname=" + nickname + "]";
	}
	
	
}
