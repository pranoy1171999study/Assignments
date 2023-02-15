package com.monocept.model;

import java.util.Iterator;

public class Node<E> {
	E value;
	Node<E> next=null;
	
	public Node(E value) {
		this.value=value;
		next=null;
	}


}
