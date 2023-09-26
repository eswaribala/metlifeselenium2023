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
public class Person {
    private FullName name;
    private Gender gender;
    private LocalDate dob;
    private String email;
    private Address address;
    private long phoneNo;
    private static int visitorCount; //static variable
//static block
    static{
        visitorCount++;
        System.out.println("Super class Static Block with visitorCount="+visitorCount);
    }

}
