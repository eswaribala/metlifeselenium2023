package com.metlife;


import com.metlife.models.FullName;
import com.metlife.models.PolicyHolder;

import java.util.Scanner;

class InsuranceApp
{
    public static void main( String[] args )
    {
      /* //declare constant
       final String planId="P725475";
       final String planName="Jeevan Dhara";

       //literals
        int number=0xFF;
        System.out.println(number);

        //floating point number
        float roi=0.7f;

        boolean active=true;*/


       System.out.println("Rocking with java....");

       //create object for the policyholder
       //left side
        //datatype, referencevariable
        //right side
        //new --> to create the object
        //default constructor Class Name with rounded bracker
       PolicyHolder policyHolder=new PolicyHolder();
      //object Id
       System.out.println(policyHolder);
       //read values from keyboard
       Scanner scanner=new Scanner(System.in);
       //read policyno
        System.out.println("Enter Policy No");
        policyHolder.setPolicyNo(scanner.nextInt());
        scanner.nextLine();
        //show the policy no
        System.out.println("Policy No="+policyHolder.getPolicyNo());

        //firstname,middle name and lastname
        FullName fullName=new FullName();
        System.out.println("Enter First Name");
        fullName.setFirstName(scanner.nextLine());
        System.out.println("Enter Middle Name");
        fullName.setMiddleName(scanner.nextLine());
        System.out.println("Enter Last Name");
        fullName.setLastName(scanner.nextLine());
        policyHolder.setName(fullName);









    }
}
