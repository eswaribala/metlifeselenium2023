package com.metlife.models;
import lombok.*;

import java.time.LocalDate;

@Getter
//@AllArgsConstructor
@NoArgsConstructor

//policyholder inheriting properties of person
public class PolicyHolder  extends Person{
    //properties
    //primitive data types
    private long policyNo;
    private LocalDate fromDate;
    private LocalDate toDate;

    public PolicyHolder(long policyNo, LocalDate fromDate, LocalDate toDate,FullName name, Gender gender, LocalDate dob, String email,
                        Address address,long phoneNo) {
        super(name, gender, dob, email, address, phoneNo);
        this.policyNo = policyNo;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public PolicyHolder(long policyNo, LocalDate fromDate, LocalDate toDate) {
        this.policyNo = policyNo;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }


    private static int visitorCount;

    static{
        visitorCount++;
        System.out.println("Sub class Static Block with visitorCount="+visitorCount);
    }

    //instance block
    {
        System.out.println("Policyholder Instance Block"+email);
    }

    //method name, no of parameters, types of parameters and return type should be same
    @Override
    public void display() {
        super.display();
        System.out.println("PolicyNo"+this.getPolicyNo());
        System.out.println("From Date="+this.fromDate.toString());

    }
}
