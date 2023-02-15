package com.monocept.test;

import java.util.LinkedList;

import com.monocept.model.MyLinkedList;

public class TestLinkedList {
	public static void main(String[] args) {
		MyLinkedList<String> ll=new MyLinkedList<String>();
		//add datas
		ll.add("Kolkata");
		ll.add("Delhi");
		ll.add("Mumbai");
		//add using index no
		ll.add(2,"Hydrabad");
		ll.show();
		//remove
		ll.remove(3);
		ll.show();
		ll.remove("Delhi");
		//show list
		ll.show();
		
		LinkedList<String> strings=new LinkedList<String>();
		for(String s:ll) {
			
		}
		
		//System.out.println(ll.get(3));
	}
}
