package com.monocept.test;

import java.util.LinkedList;

import com.monocept.model.MyLinkedList;
import com.monocept.model.Node;

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
		
		ll.add("Delhi");
		ll.add("Mumbai");
		ll.show();
		LinkedList<String> strings=new LinkedList<String>();
		for(Node<String> node:ll) {
			System.out.print(node.value+" ");
		}
		
		//System.out.println(ll.get(3));
	}
}
