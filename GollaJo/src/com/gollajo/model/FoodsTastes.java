package com.gollajo.model;

public class FoodsTastes {
	private int foodTasteIdx;
	private int foodIdx;
	private int tasteIdx;
	public int getFoodTasteIdx() {
		return foodTasteIdx;
	}
	public void setFoodTasteIdx(int foodTasteIdx) {
		this.foodTasteIdx = foodTasteIdx;
	}
	public int getFoodIdx() {
		return foodIdx;
	}
	public void setFoodIdx(int foodIdx) {
		this.foodIdx = foodIdx;
	}
	public int getTasteIdx() {
		return tasteIdx;
	}
	public void setTasteIdx(int tasteIdx) {
		this.tasteIdx = tasteIdx;
	}
	public FoodsTastes(int foodTasteIdx, int foodIdx, int tasteIdx) {
		super();
		this.foodTasteIdx = foodTasteIdx;
		this.foodIdx = foodIdx;
		this.tasteIdx = tasteIdx;
	}
	@Override
	public String toString() {
		return "FoodsTastes [foodTasteIdx=" + foodTasteIdx + ", foodIdx=" + foodIdx + ", tasteIdx=" + tasteIdx + "]";
	}
	
}
