package com.metlife;

import java.util.ArrayList;
import java.util.Iterator;

public class InsuranceAppV4 {

    public static void main(String[] args){

        ArrayList list=new ArrayList();
        list.add(42858);
        list.add("Hi");
        list.add(10.23f);
        list.add(true);

        //display
        Iterator itr=list.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }



    }
}
