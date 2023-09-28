package com.metlife;

import com.metlife.exceptions.DOBException;
import com.metlife.models.FullName;
import com.metlife.models.PolicyHolder;

import java.time.LocalDate;

public class CustomExceptionDemo {

    public static void main(String[] args){
        FullName fullName=new FullName();
        fullName.setFirstName("Parameswari");

        PolicyHolder policyHolder=new PolicyHolder();
        try {
            if (LocalDate.now().plusDays(10).isAfter(LocalDate.now()))
                throw new DOBException("Date of Birth cannot be after current Date");
            else
                policyHolder.setDob(LocalDate.now().plusDays(10));
            System.out.println(policyHolder.getDob().toString());
        }
        catch (DOBException ex){
           System.out.println(ex.getMessage());
        }

    }
}
