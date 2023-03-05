package com.monocept.model;

public class ResultAnalyzer {
	Board board;
	ResultType result = ResultType.PROGRESS;

	public ResultAnalyzer(Board board, ResultType result) {
		super();
		this.board = board;
		this.result = result;
	}

	public void horizontalWinCheck() {
		for (int i = 0; i < 3; i++) {
			int c = 0;
			for (int j = 1; j < 3; j++) {
				if (!board.cell[i * 3 + j - 1].getMark() .equals( MarkType.EMPTY)
						&& board.cell[i * 3 + j].getMark().equals(board.cell[i * 3 + j - 1].getMark()))
					c++;
			}
			//System.out.println(c);
			if (c == 2) {
				result = ResultType.WIN;
			}
		}
	}

	public void verticalWinCheck() {
//		for (int i = 0; i < 3; i++) {
//			int c = 0;
//			for (int j = 1; j < 3; j++) {
//				System.out.println("test"+(j*3+i));
//				if (board.cell[i].getMark() != MarkType.EMPTY
//						&& board.cell[j * 3 + i].getMark().equals(board.cell[j * 3 + i - 1].getMark()))
//					c++;
//			}
//			System.out.println("fg"+c);
//			if (c == 2) {
//				result = ResultType.WIN;
//			}
//		}
		for(int i=0;i<3;i++) {
			if(board.cell[i].getMark()==board.cell[i+3].getMark()&&board.cell[i+3].getMark()==board.cell[i+6].getMark()&&board.cell[i].getMark()!=MarkType.EMPTY) {
				result=ResultType.WIN;
				break;
			}
		}
	}

	public void diagonalWinCheck() {
		if (board.cell[0].getMark() != MarkType.EMPTY)
			if (board.cell[0].getMark() == board.cell[4].getMark()
					&& board.cell[4].getMark() == board.cell[8].getMark()) {
				result = ResultType.WIN;
			}
		if (board.cell[2].getMark() != MarkType.EMPTY)
			if (board.cell[2].getMark() == board.cell[4].getMark()
					&& board.cell[4].getMark() == board.cell[6].getMark()) {
				result = ResultType.WIN;
			}
	}

	public ResultType analyzeResult() {
		horizontalWinCheck();
		verticalWinCheck();
		diagonalWinCheck();
		
		
		
		if (result == ResultType.PROGRESS) {
			if (board.isBoardFull())
				result = ResultType.DRAW;
		}
		return result;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ResultType getResult() {
		analyzeResult();
		return result;
	}

	public void setResult(ResultType result) {
		this.result = result;
	}
	
}
