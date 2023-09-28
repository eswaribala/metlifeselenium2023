package com.metlife;

import com.metlife.exceptions.DOBException;
import com.metlife.models.FullName;
import com.metlife.models.PolicyHolder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class CustomExceptionDemo {

    public static void main(String[] args)  {
        FullName fullName=new FullName();
        fullName.setFirstName("Parameswari");
        File file=new File("db.txt");
        FileWriter fileWriter=null;

        PolicyHolder policyHolder=new PolicyHolder();
        try {
            fileWriter=new FileWriter(file);
            checkDOB(LocalDate.now().minusDays(10),policyHolder);
            System.out.println(policyHolder.getDob().toString());

        }
        catch (DOBException | IOException ex){
           System.out.println(ex.getMessage());
        }
        finally{
            try {
                fileWriter.close();
            } catch (IOException e) {
             System.out.println(e.getMessage());
            }
            System.out.println("File Closed");
        }

    }

    private static void checkDOB(LocalDate date, PolicyHolder policyHolder) throws DOBException {

        if (date.isAfter(LocalDate.now()))
            throw new DOBException("Date of Birth cannot be after current Date");
        else
            policyHolder.setDob(date);
    }
}
