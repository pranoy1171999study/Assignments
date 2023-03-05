package com.monocept.model;

public class Player {
	String name;
	MarkType mark=MarkType.EMPTY;
	public Player(String name,MarkType mark) {
		super();
		this.name = name;
		this.mark=mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MarkType getMark() {
		return mark;
	}

	public void setMark(MarkType mark) {
		this.mark = mark;
	}
	
}
