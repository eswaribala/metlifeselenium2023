package com.metlife;

import com.metlife.models.*;

import java.time.LocalDate;
import java.util.Random;

public class InsuranceAppv1 {

    public static void main(String[] args){
        //use parameterized constructor
        PolicyHolder policyHolder=new PolicyHolder(new Random().nextInt(10000000),
                LocalDate.of(2000+new Random().nextInt(23),1+new Random().nextInt(10),
                        1+new Random().nextInt(25)),
                LocalDate.of(2000+new Random().nextInt(30),1+new Random().nextInt(10),
                        1+new Random().nextInt(25)),new FullName(),
                Gender.MALE,
                LocalDate.of(1980+new Random().nextInt(30),1+new Random().nextInt(10),
                        1+new Random().nextInt(25)),
                "sample@gmail.com",new Address(),1234567890L
                        );

        System.out.println(policyHolder);
        policyHolder.display();

        //runtime polymorphism or upcasting
        Person person=policyHolder;
        person.display();


        //invoke ClaimOfficer

        ClaimOfficer claimOfficer=new ClaimOfficer();
       System.out.println("Approval Status="+claimOfficer.claimApproval(policyHolder));



    }

}
