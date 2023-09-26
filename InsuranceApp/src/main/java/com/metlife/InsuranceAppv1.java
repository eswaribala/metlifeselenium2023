package com.metlife;

import com.metlife.models.Address;
import com.metlife.models.FullName;
import com.metlife.models.Gender;
import com.metlife.models.PolicyHolder;

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

    }

}
