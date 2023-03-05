package com.monocept.model;

public class CellAlreadyMarkedExceptin extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CellAlreadyMarkedExceptin() {
		super("Cell Already Occupied!!");
	}
}
