package com.monocept.model;

public class Cell {
	MarkType mark;

	public Cell() {
		this.mark = MarkType.EMPTY;
	}

	public Cell(MarkType mark) {
		this.mark = mark;
	}

	public boolean isEmpty() {
		if (mark == MarkType.EMPTY)
			return true;
		return false;
	}

	public MarkType getMark() {
		return mark;
	}

	public void setMark(MarkType mark) throws Exception {
		if (isEmpty())
			this.mark = mark;
		else
			throw new RuntimeException("Err");

	}

	@Override
	public String toString() {
		if(mark==MarkType.EMPTY) return " ";
		return mark+"";
	}

}
