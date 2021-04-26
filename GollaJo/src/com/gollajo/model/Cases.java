package com.gollajo.model;

public class Cases {
	private int caseIdx;
	private String cases;
	public int getCaseIdx() {
		return caseIdx;
	}
	public void setCaseIdx(int caseIdx) {
		this.caseIdx = caseIdx;
	}
	public String getCases() {
		return cases;
	}
	public void setCases(String cases) {
		this.cases = cases;
	}
	public Cases(int caseIdx, String cases) {
		super();
		this.caseIdx = caseIdx;
		this.cases = cases;
	}
	@Override
	public String toString() {
		return "Cases [caseIdx=" + caseIdx + ", cases=" + cases + "]";
	}
	
	
}
