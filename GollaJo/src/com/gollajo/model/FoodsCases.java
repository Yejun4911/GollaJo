package com.gollajo.model;

public class FoodsCases {
	private int foodCaseIdx;
	private int foodIdx;
	private int caseIdx;
	public int getFoodCaseIdx() {
		return foodCaseIdx;
	}
	public void setFoodCaseIdx(int foodCaseIdx) {
		this.foodCaseIdx = foodCaseIdx;
	}
	public int getFoodIdx() {
		return foodIdx;
	}
	public void setFoodIdx(int foodIdx) {
		this.foodIdx = foodIdx;
	}
	public int getCaseIdx() {
		return caseIdx;
	}
	public void setCaseIdx(int caseIdx) {
		this.caseIdx = caseIdx;
	}
	public FoodsCases(int foodCaseIdx, int foodIdx, int caseIdx) {
		super();
		this.foodCaseIdx = foodCaseIdx;
		this.foodIdx = foodIdx;
		this.caseIdx = caseIdx;
	}
	@Override
	public String toString() {
		return "FoodsCases [foodCaseIdx=" + foodCaseIdx + ", foodIdx=" + foodIdx + ", caseIdx=" + caseIdx + "]";
	}
	
	
	
}
