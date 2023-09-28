package com.metlife;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args){
        TreeMap<String,Long> policyMap=new TreeMap<String,Long>();
        policyMap.put("Life Insurance",100000000L);
        policyMap.put("Jeevan Bhima",320000000L);
        policyMap.put("Jeevan Dhara",150000000L);
        policyMap.put("Auto Insurance",2000000L);
        policyMap.put("Medical Insurance",5000000L);

        //display
        Set<Map.Entry<String,Long>> set=policyMap.entrySet();
        Iterator<Map.Entry<String,Long>> itr= set.iterator();

        Map.Entry<String,Long> entry=null;
        while(itr.hasNext()){
         entry=itr.next();
         System.out.println(entry.getKey()+","+entry.getValue());

        }



    }

}
