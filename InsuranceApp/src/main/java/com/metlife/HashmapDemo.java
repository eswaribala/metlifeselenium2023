package com.metlife;

import com.metlife.models.Address;
import com.metlife.models.FullName;
import com.metlife.models.Gender;
import com.metlife.models.PolicyHolder;

import java.time.LocalDate;
import java.util.*;

public class HashmapDemo {

    public static void main(String[] args){

        HashMap<Long, PolicyHolder> policyHolderHashMap=new HashMap<Long,PolicyHolder>();
        long policyNo=0;
        for(int i=0;i<100;i++){

            policyNo=new Random().nextInt(1000000);
            policyHolderHashMap.put(policyNo, new PolicyHolder(policyNo,
                    LocalDate.of(2000+new Random().nextInt(23),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),
                    LocalDate.of(2000+new Random().nextInt(30),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),new FullName("FirstName","MiddleName","LastName"),
                    Gender.MALE,
                    LocalDate.of(1980+new Random().nextInt(30),1+new Random().nextInt(10),
                            1+new Random().nextInt(25)),
                    "sample@gmail.com",new Address(),1234567890+new Random().nextInt(1000)));
        }

        Set<Map.Entry<Long,PolicyHolder>> mapEntries= policyHolderHashMap.entrySet();

        Iterator<Map.Entry<Long, PolicyHolder>> itr=mapEntries.iterator();

        Map.Entry<Long,PolicyHolder> entry=null;
        while(itr.hasNext()){

            entry=  itr.next();
            System.out.println(entry.getKey()+","+entry.getValue().getFromDate()+","+entry.getValue().getToDate());

        }





    }
}
