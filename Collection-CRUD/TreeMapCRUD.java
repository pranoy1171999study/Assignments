package com.monocept.test;

import java.util.TreeMap;

public class TreeMapCRUD {
	public static void main(String[] args) {
		TreeMap<String, String> statesWithCapitals=new TreeMap<String, String>();
		// put elements to back of the list
        statesWithCapitals.put("WB","Calcutta");
        statesWithCapitals.put("AP","Amravati");
        statesWithCapitals.put("Maharastra","Mumbai");
        statesWithCapitals.put("Telengana","Hydrabad");
        System.out.println(statesWithCapitals); 

        
        //Update value
        statesWithCapitals.put("WB","Kolkata");
        System.out.println(statesWithCapitals);
        // get specific value by key
        String str = statesWithCapitals.get("WB");
        System.out.println(str); 
        
        // find out number of elements in the list
        int size = statesWithCapitals.size();
        System.out.println("Size: " + size); 
        
       
        
        // remove by value
        statesWithCapitals.remove("AP");
        System.out.println(statesWithCapitals);
        
 
        
        // check if list contains specified key or value
        boolean isThere = statesWithCapitals.containsKey("WB");
        System.out.println(isThere); 
        isThere = statesWithCapitals.containsValue("Kolkata");
        System.out.println(isThere); 
	}
}
