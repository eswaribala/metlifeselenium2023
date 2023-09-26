package com.metlife.models;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
//policyholder inheriting properties of person
public class PolicyHolder  extends Person{
    //properties
    //primitive data types
    private long policyNo;
    private LocalDate fromDate;
    private LocalDate toDate;


}
