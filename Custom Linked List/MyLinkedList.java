package com.monocept.model;

import java.util.*;


public class MyLinkedList<E> implements Iterable<Node<E>>{
	private Node<E> head;
	private int size;
	
	public MyLinkedList() {
		head=null;
		size=0;
	}
	
	/*Remove element start*/
	//by element
	public boolean remove(E x) {
		if(isEmpty()) return false;
		if(head.value==x) {
			head=head.next;
			size--;
			return true;
		}
		Node<E> currNode=head;
		while(currNode.next.value!=x&&currNode.next!=null) {
			currNode=currNode.next;
		}
		if(currNode.next.value==x) {
			currNode.next=currNode.next.next;
			size--;
			return true;
		}
		return false;
	}
	//by index
	public boolean remove(int pos) {
		if(pos<0||pos>=size||isEmpty()) return false;
		if(pos==0) {
			head=head.next;
			size--;
			return true;
		}
		if(pos==size-1) {
			Node<E> currNode=head;
			while(currNode.next.next!=null) 
				currNode=currNode.next;
			currNode.next=null;
			size--;
			return true;
		}
		Node<E> currNode=head;
		for(int i=0;i<pos-1;i++) {
			currNode=currNode.next;
		}
		currNode.next=currNode.next.next;
		size--;
		return true;

	}
	/*Remove element end*/
	
	
	/*Add element start*/
	public void add(E x) {
		//by default add element at the end
		add(size,x);
	}
	public boolean add(Integer pos,E x) {
		if(pos<0||pos>size) return false;
		
		Node<E> newNode = new Node(x);
		if(pos==0) {
			if(head==null) {
				head=newNode;
				size++;
				return true;
			}
			newNode.next=head;
			head=newNode;
			size++;
			return true;
		}
		Node<E> currNode=head;
		for(int i=0;i<pos-1;i++) {
			currNode=currNode.next;
		}
		Node<E> tempNode=currNode.next;
		newNode.next=tempNode;
		currNode.next=newNode;
		size++;
		return true;
	}
	/*Add element end*/
	
	
	
	/*Display*/
	public E get(int pos) {
		//pos start from 0 but size from 1
		if(pos<0||pos>=size) return null;
		Node<E> currNode=head;
		for(int i=0;i<pos;i++) {
			currNode=currNode.next;
		}
		return currNode.value;
	}
	public void show() {
		String res="";
		Node<E> currNode=head;
		while(currNode!=null) {
			res+=(currNode.value.toString()+" ");
			currNode=currNode.next;
		}
		System.out.println(res);
	}
	
	public boolean isEmpty() {
		if(head==null) return true;
		return false;
	}
	/*Set Iterate*/
	@Override
	public Iterator<Node<E>> iterator() {
		return new Iterator<Node<E>> () {
			private Node<E> curr=head;
			 @Override
			    public boolean hasNext() {
			        return curr != null;
			    }

			    @Override
			    public Node next() {
			        Node<E> temp = curr;
			        curr = curr.next;
			        return temp;
			    }    
		};
	}
	
	
	
}
//1>Add
//2>Display
//3>Remove
//4>Iterate


