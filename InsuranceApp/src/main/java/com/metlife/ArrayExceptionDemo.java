package com.metlife;

import com.metlife.models.ClaimOfficer;
import com.metlife.models.Employee;
import com.metlife.models.Person;
import com.metlife.models.PolicyHolder;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class ArrayExceptionDemo {

    public static void main(String[] args){
        int x=10;
        int y=0;
         Scanner scanner=new Scanner(System.in);
         System.out.println("Enter index");
         int index=scanner.nextInt();
         scanner.nextLine();
        try {
            System.out.println(args[index]); //unchecked
            System.out.println("Enter y value");
            y=scanner.nextInt();
            scanner.nextLine();
            System.out.println(x / y); //unchecked
        }
        catch (ArrayIndexOutOfBoundsException |ArithmeticException  ex){
            System.out.println(ex.getMessage());
        }




    }
}
