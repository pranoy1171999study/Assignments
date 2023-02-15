package com.monocept.model;

import java.util.Iterator;

public class Node<E> {
	public E value;
	public Node<E> next=null;
	
	public Node(E value) {
		this.value=value;
		next=null;
	}


}
