package com.chainsys.springproject.beans;

public class ScoreBoard {
	public int targetScore;
	private ScoreBoard() {
		System.out.println("ScoreBoard object is created!!");
	}
	
	private ScoreBoard(int run) {
		targetScore = run;
		System.out.println("ScoreBoard object is created!!"  +run);
	}

// Factory method - The methods are static here
	public static ScoreBoard createObject() {
		return new ScoreBoard();
	}
	public static ScoreBoard createObject(int runs) {
		return new ScoreBoard(runs);
	}


}
