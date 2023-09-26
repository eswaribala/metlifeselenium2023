package com.metlife.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    private FullName name;
    private Gender gender;
    private LocalDate dob;
    private String email;
    private Address address;
    private long phoneNo;

}
