package com.monocept.TicTacToe;

import java.util.Scanner;

public class TicTacToe {
	private int size=3;
	private char location[][] = new char [size][size];
	Player p1,p2;
	int inpcount=0;
	private void showBox() {
		
		for(int i=0;i<size;i++)
		{
			System.out.print("|");
			for(int j=0;j<size;j++)
			{
				if(location[i][j]!=' ')
					System.out.print(location[i][j]+"|");
				else System.out.print(" |");
			}
			System.out.print("\n.......\n");
			
		}
	}
	private boolean findWinner() {
		//cheeck rows
		int c=0;
		for(int i=0;i<size;i++)
		{
			c=0;
			if(location[i][0]!=' ')
			for(int j=1;j<size;j++) {
				if(location[i][j-1]==location[i][j]) c++;
			}
			if(c==size-1) { System.out.println("1"); return true; }
		}
		//cheeck cols
		
		for(int i=0;i<size;i++)
		{
			c=0;
			if(location[0][i]!=' ')
			for(int j=1;j<size;j++) {
				if(location[j-1][i]==location[j][i]) c++;
			}
			if(c==size-1) { System.out.println("2"); return true; }
		}	
		//check diagonals
		c=0;
		if(location[0][0]!=' ')
		for(int i=1;i<size;i++) {
			if(location[i-1][i-1]==location[i][i]) c++;
		}
		if(c==size-1) { System.out.println("3"); return true; }
		//second diagonal
		c=0;
		int k=0;
		if(location[0][size-1]!=' ')
		for(int i=size-1;i>0;i--) {
			if(location[k][i]==location[k+1][i-1]) c++;
			k++;
		}
		if(c==size-1) { System.out.println("4"); return true; }
		
		return false;
	}
	private void initializeGame() {
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				location[i][j]=' ';
			}
		}
		p1=new Player();
		p2=new Player();
		System.out.println("Enter 1st user name : ");
		p1.setName(scanner.next());
		System.out.println("Enter 2nd user name : ");
		p2.setName(scanner.next());
	}
	private void playerInputs(Player player,char symbol) {
		int r=0,c=0;
		System.out.println("Player "+player.getName()+", enter your move (row[1-3] column[1-3]): ");
		Scanner scanner = new Scanner(System.in);
		r=scanner.nextInt();
		c=scanner.nextInt();
		if(!validateInput(r, c)) {
			playerInputs(player, symbol);
		}
		if(location[r-1][c-1]!=' ') {
			System.out.println("Space already occupied (Try new cell)");
			playerInputs(player,symbol);
		}
		else {
			inpcount++;
			location[r-1][c-1]=symbol;
		}
		showBox();
	}
	public void startGame() {
		initializeGame();
		boolean P1Turn=true;
		Player tempPlayer=p1;
		char symbol='X';
		while(!findWinner()) {
			
			if(P1Turn) {
				//player1 turn
				tempPlayer=p1;
				symbol='X';
				
			}
			else {
				//Player 2 turn
				tempPlayer=p2;
				symbol='O';
			}
			playerInputs(tempPlayer, symbol);
			if (findWinner()) {
				//we found winner
				System.out.println("Hola We got our Winner !!!!!!! "+tempPlayer.getName());
				askingForNewGame();
				break;
			}
			if(inpcount>=(size*size)) {
				if(cheeckNoWinner()) {
					System.out.println("No boxes left (Game Ended)!!");
					askingForNewGame();
					break;
				}
			}
			P1Turn=!P1Turn;
		}
		
	}
	private void askingForNewGame() {
		System.out.println("Do you want a new game ? (y/n)");
		Scanner scanner=new Scanner(System.in);
		char inp=scanner.next().charAt(0);
		if(inp=='y') {
			inpcount=0;
			startGame();
		}
		else {
			System.out.println("Thank You !!!!");
		}
	}
	private boolean cheeckNoWinner() {
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(location[i][j]==' ') return false;
			}
		}
		return true;
	}
	private boolean validateInput(int r,int c) {
		if(1<=r && r<=size && 1<=c && c<=size) return true;
		System.out.println("Please enter between range [1,"+size+"]");
		return false;
	}
	public static void main(String[] args) {
		TicTacToe tcTacToe=new TicTacToe();
		tcTacToe.startGame();
	}
}
