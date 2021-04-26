package com.gollajo.model;

public class Foods {
	private int foodIdx;
	private String name;
	private String url;
	public int getFoodIdx() {
		return foodIdx;
	}
	public void setFoodIdx(int foodIdx) {
		this.foodIdx = foodIdx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Foods(int foodIdx, String name, String url) {
		super();
		this.foodIdx = foodIdx;
		this.name = name;
		this.url = url;
	}
	@Override
	public String toString() {
		return "Foods [foodIdx=" + foodIdx + ", name=" + name + ", url=" + url + "]";
	}
	
	
	
	
}
