package com.monocept.model;

public class Game {
	Player currentPlayer;
	Player []players=new Player [2];
	ResultAnalyzer analyser;
	public Game(Player players[],Player currentPlayer,ResultAnalyzer analyser) {
		super();
		this.players=players;
		this.currentPlayer = currentPlayer;
		this.analyser = analyser;
	}
	public Player getCurrentPlayer() {
		return currentPlayer;
	}
	public void setCurrentPlayer(Player currentPlayer) {
		this.currentPlayer = currentPlayer;
	}
	public Player[] getPlayers() {
		return players;
	}
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	public ResultAnalyzer getAnalyser() {
		return analyser;
	}
	public void setAnalyser(ResultAnalyzer analyser) {
		this.analyser = analyser;
	}
	public void play(int loc) throws Exception {
		if(currentPlayer==players[0])
			analyser.getBoard().setCellMark(loc, MarkType.O);
		else 
			analyser.getBoard().setCellMark(loc, MarkType.X);
		analyser.analyzeResult();
		System.out.println(analyser.getResult());
//		ResultType result=analyser.getResult();
//		if(result!=ResultType.PROGRESS) {
//			if(result==ResultType.WIN) {
//				
//			}
//			if(result==ResultType.DRAW) {
//				
//			}
//		}
		//switchPlayer();
		
	}
	public void switchPlayer() {
		if(currentPlayer==players[0])
			currentPlayer=players[1];
		else currentPlayer=players[0];
	}
}
