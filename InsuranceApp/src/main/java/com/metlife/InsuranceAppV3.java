package com.metlife;

import com.metlife.models.Address;
import com.metlife.models.FullName;
import com.metlife.models.Gender;
import com.metlife.models.PolicyHolder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class InsuranceAppV3 {

    public static void main(String[] args){
          //100 policyholders
        //array list
        ArrayList<PolicyHolder> policyHolders=new ArrayList<PolicyHolder>();
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter no of policyholders to be generated...");
        int n=scanner.nextInt();
        scanner.nextLine();
        for(int i=0;i<n;i++){

            policyHolders.add(new PolicyHolder(new Random().nextInt(10000000),
                    LocalDate.of(2000+new Random().nextInt(23),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),
                    LocalDate.of(2000+new Random().nextInt(30),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),new FullName("FirstName","MiddleName","LastName"),
                    Gender.MALE,
                    LocalDate.of(1980+new Random().nextInt(30),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),
                    "sample@gmail.com",new Address(),1234567890+new Random().nextInt(1000)));
        }
//display

        System.out.println("Before Sorting..........................");
        //display 100 policy holders
        for(PolicyHolder policyHolder:policyHolders){
            System.out.println(policyHolder.getPolicyNo()+","+policyHolder.getFromDate().toString()+","+policyHolder.getToDate().toString());
        }





    }
}
