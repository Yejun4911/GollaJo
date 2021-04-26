package com.gollajo.model;

public class BoardVotes {
	private int boardVoteIdx;
	private int userIdx;
	private int boardIdx;
	private int vote;
	public int getBoardVoteIdx() {
		return boardVoteIdx;
	}
	public void setBoardVoteIdx(int boardVoteIdx) {
		this.boardVoteIdx = boardVoteIdx;
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
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	public BoardVotes(int boardVoteIdx, int userIdx, int boardIdx, int vote) {
		super();
		this.boardVoteIdx = boardVoteIdx;
		this.userIdx = userIdx;
		this.boardIdx = boardIdx;
		this.vote = vote;
	}
	@Override
	public String toString() {
		return "BoardVotes [boardVoteIdx=" + boardVoteIdx + ", userIdx=" + userIdx + ", boardIdx=" + boardIdx
				+ ", vote=" + vote + "]";
	}
	
}
