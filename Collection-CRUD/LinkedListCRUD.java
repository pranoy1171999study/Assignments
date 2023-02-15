package com.monocept.test;

import java.util.LinkedList;

public class LinkedListCRUD {
	public static void main(String[] args) {
		LinkedList<String> citis = new LinkedList<String>();
		// add elements to back of the list
        citis.add("Kolkata");
        citis.add("Delhi");
        citis.add("Mumbai");
        System.out.println(citis); 

        // insert element at specified position
        citis.add(1, "Hydrabad");
        System.out.println(citis); 
        
        // get specific element by index
        String str = citis.get(2);
        System.out.println(str); 
        
        // find out number of elements in the list
        int size = citis.size();
        System.out.println("Size: " + size); 
        //update by index
        citis.set(0, "Calcutta");
        System.out.println(citis);
        // remove by index
        citis.remove(0);
        System.out.println(citis); 
        
        // remove by value
        citis.remove("Mumbai");
        System.out.println(citis);
        
        // find index of specific element
        int index = citis.indexOf("Delhi");
        System.out.println(index); 
        
        // check if list contains specified element
        boolean isThere = citis.contains("Midnapore");
        System.out.println(isThere); 
	}
}
