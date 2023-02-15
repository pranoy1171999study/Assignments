package com.monocept.test;

import java.util.TreeSet;

public class TreeSetCRUD {
	public static void main(String[] args) {
		TreeSet<String> citis = new TreeSet<String>();
		// add elements to back of the list
        citis.add("Kolkata");
        citis.add("Delhi");
        citis.add("Mumbai");
        System.out.println(citis); 

        
        // find out number of elements in the list
        int size = citis.size();
        System.out.println("Size: " + size); 
        
        
        // remove by value
        citis.remove("Mumbai");
        System.out.println(citis);
        
        
        // check if list contains specified element
        boolean isThere = citis.contains("Midnapore");
        System.out.println(isThere); 
	}
}
