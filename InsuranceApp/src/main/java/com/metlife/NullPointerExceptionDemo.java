package com.metlife;

import com.metlife.models.PolicyHolder;

public class NullPointerExceptionDemo {

    public static void main(String[] args){

        PolicyHolder policyHolder=null;

        System.out.println(policyHolder.getPolicyNo()+","+policyHolder.getFromDate());

    }

}
