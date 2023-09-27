package com.metlife;

import com.metlife.models.Address;
import com.metlife.models.FullName;
import com.metlife.models.Gender;
import com.metlife.models.PolicyHolder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Random;

public class InsuranceAppv2 {

    public static void main(String[] args){

           // generate 100 policyholders and sort them by to date

        PolicyHolder[] policyHolders=new PolicyHolder[100];

        for(int i=0;i<100;i++){
            policyHolders[i]=new PolicyHolder(new Random().nextInt(10000000),
                    LocalDate.of(2000+new Random().nextInt(23),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),
                    LocalDate.of(2000+new Random().nextInt(30),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),new FullName("FirstName","MiddleName","LastName"),
                    Gender.MALE,
                    LocalDate.of(1980+new Random().nextInt(30),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),
                    "sample@gmail.com",new Address(),1234567890+new Random().nextInt(1000)
            );

        }

        System.out.println("Before Sorting..........................");
        //display 100 policy holders
        for(PolicyHolder policyHolder:policyHolders){
            System.out.println(policyHolder.getPolicyNo()+","+policyHolder.getFromDate().toString()+","+policyHolder.getToDate().toString());
        }

        System.out.println("After Sorting..........................");

        Arrays.sort(policyHolders);

        for(PolicyHolder policyHolder:policyHolders){
            System.out.println(policyHolder.getPolicyNo()+","+policyHolder.getFromDate().toString()+","+policyHolder.getToDate().toString());
        }



    }
}
