package com.metlife;

import java.util.HashSet;
import java.util.Set;

public class TraineeApp {

    public static void main(String[] args){

        HashSet<String> javaSet=new HashSet<String>();
        HashSet<String> seleniumSet=new HashSet<String>();
        //added javaset
        for(int i=1;i<10;i++)
            javaSet.add("t"+i);

        //added seleniumset
        for(int i=6;i<15;i++)
            seleniumSet.add("t"+i);

        System.out.println(seleniumSet);
        seleniumSet.retainAll(javaSet);
        System.out.println("Intersection count"+seleniumSet.size());
        System.out.println(seleniumSet);



    }
}
