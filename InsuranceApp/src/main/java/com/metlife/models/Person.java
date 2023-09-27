package com.metlife.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
abstract public class Person {
    protected FullName name;
    protected Gender gender;
    protected LocalDate dob;
    protected String email; //inherited property
    protected Address address;
    protected long phoneNo;
    //static cannot be inherited
    private static int visitorCount; //static variable
//static block
    static{
        visitorCount++;
       // System.out.println("Super class Static Block with visitorCount="+visitorCount);
    }

    //instance block
    {
        //System.out.println("Person Instance Block"+email);
    }


    public abstract void display();

}
