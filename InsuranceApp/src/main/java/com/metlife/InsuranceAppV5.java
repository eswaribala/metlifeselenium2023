package com.metlife;

import com.metlife.models.Address;
import com.metlife.models.FullName;
import com.metlife.models.Gender;
import com.metlife.models.PolicyHolder;

import java.time.LocalDate;
import java.util.PriorityQueue;
import java.util.Random;

public class InsuranceAppV5 {

    public static void main(String[] args){

        PriorityQueue<PolicyHolder> policyHolders=new PriorityQueue<PolicyHolder>();
        for(int i=0;i<100;i++){
            policyHolders.offer(new PolicyHolder(new Random().nextInt(10000000),
                    LocalDate.of(2000+new Random().nextInt(23),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),
                    LocalDate.of(2000+new Random().nextInt(30),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),new FullName("FirstName","MiddleName","LastName"),
                    Gender.MALE,
                    LocalDate.of(1980+new Random().nextInt(30),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),
                    "sample@gmail.com",new Address(),1234567890+new Random().nextInt(1000)));
        }


        //display policy holders

        PolicyHolder policyHolder=null;
        while(!policyHolders.isEmpty()){
            policyHolder=policyHolders.poll();

            System.out.println(policyHolder.getPolicyNo()+","+policyHolder.getFromDate());
        }


    }
}
