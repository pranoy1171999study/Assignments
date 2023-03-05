package com.monocept.test;

import java.io.Console;
import java.util.Scanner;

import com.monocept.model.Board;
import com.monocept.model.Game;
import com.monocept.model.MarkType;
import com.monocept.model.Player;
import com.monocept.model.ResultAnalyzer;
import com.monocept.model.ResultType;

public class TicTacToeConsoleTest {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		Player players[]=new Player[2];
		ResultAnalyzer analyser=new ResultAnalyzer(new Board(), ResultType.PROGRESS);
		Game game;
		
		System.out.println("Welcome to TicTacToe Game!!!");
		System.out.println("Enter Player 1 name : ");
		players[0]=new Player(sc.next(),MarkType.O);
		System.out.println("Enter Player 2 name : ");
		players[1]=new Player(sc.next(),MarkType.X);
		game=new Game(players, players[0], analyser);
		
		while(game.getAnalyser().getResult()!=ResultType.DRAW||game.getAnalyser().getResult()!=ResultType.WIN) {
			System.out.println(game.getCurrentPlayer().getName()+" Turn (Enter location between 1 to 9) :");
			int loc=sc.nextInt()-1;
			if(loc<0||loc>8) {
				System.out.println("invalid Input!!");
				continue;
			}
			try {
				game.getAnalyser().getBoard().setCellMark(loc,game.getCurrentPlayer().getMark());
			} catch (Exception e) {
				e.printStackTrace();
			}
			game.getAnalyser().getBoard().showBoard();
			if(game.getAnalyser().getResult()==ResultType.WIN) {
				System.out.println(game.getCurrentPlayer().getName()+" Win!!!");
				break;
			}
			if(game.getAnalyser().getResult()==ResultType.DRAW) {
				System.out.println("Game Draw!!!");
				break;
			}
			game.switchPlayer();
			
		}
	}
}
