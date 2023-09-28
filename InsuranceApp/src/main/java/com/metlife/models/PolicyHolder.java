package com.metlife.models;
import lombok.*;

import java.time.LocalDate;

@Getter
//@AllArgsConstructor
@NoArgsConstructor

//policyholder inheriting properties of person
public class PolicyHolder  extends Person implements Comparable{
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
       // System.out.println("Sub class Static Block with visitorCount="+visitorCount);
    }

    //instance block
    {
       // System.out.println("Policyholder Instance Block"+email);
    }

    //method name, no of parameters, types of parameters and return type should be same
    @Override
    public void display() {
       System.out.println("FullName="+this.name.getFirstName()+"-"+this.name.getMiddleName()+"-"+this.name.getLastName());
        System.out.println("PolicyNo"+this.getPolicyNo());
        System.out.println("From Date="+this.fromDate.toString());

    }

  /*  @Override
    public int compareTo(Object o) {
        PolicyHolder policyHolder= (PolicyHolder) o;
        if(this.policyNo>policyHolder.getPolicyNo())
            return 1;
        else if (this.policyNo<policyHolder.policyNo) {
            return -1;

        }
        else
            return 0;


    }*/

    @Override
    public int compareTo(Object o) {
        PolicyHolder policyHolder= (PolicyHolder) o;
        return this.fromDate.compareTo(policyHolder.fromDate);


    }
}
