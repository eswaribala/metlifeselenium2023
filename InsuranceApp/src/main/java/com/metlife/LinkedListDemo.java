package com.metlife;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args){
        LinkedList<String> policyNames=new LinkedList<String>();
        policyNames.addFirst("Jeevan Dhara");
        for(int i=0;i<100;i++){
            policyNames.add("policyName"+i);
        }
        policyNames.addLast("JeevanBhima");

        //display
        for( String name: policyNames)
            System.out.println(name);


    }

}
