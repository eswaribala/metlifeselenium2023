package com.metlife.models;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PolicyHolder {
    //properties
    //primitive data types
    private long policyNo;
    private LocalDate fromDate;
    private LocalDate toDate;
    private FullName name;
    private Gender gender;
    private LocalDate dob;
    private String email;
    private Address address;
    private long phoneNo;

}
