package com.monocept.model;

public class Board {
	public Cell [] cell=new Cell[9];

	public Board() {
		super();
		for(int i=0;i<9;i++) {
			cell[i]=new Cell();
		}
	}
	public boolean isBoardFull() {
		for(int i=0;i<9;i++) {
			if(cell[i].getMark().equals(MarkType.EMPTY)) return false;
		}
		return true;
	}
	public void setCellMark(int loc,MarkType mark) throws Exception{
		if(cell[loc].getMark().equals(MarkType.EMPTY)) {
			cell[loc].setMark(mark);
		}
		else throw new CellAlreadyMarkedExceptin();
	}
	public void showBoard() {
		System.out.print("|");
		for(int i=0;i<3;i++)
			System.out.print(" "+cell[i]+" |");
		System.out.print("\n-------------");
		System.out.print("\n|");
		for(int i=3;i<6;i++)
			System.out.print(" "+cell[i]+" |");
		System.out.print("\n-------------");
		System.out.print("\n|");
		for(int i=6;i<9;i++)
			System.out.print(" "+cell[i]+" |");
		System.out.print("\n");
	}
}
