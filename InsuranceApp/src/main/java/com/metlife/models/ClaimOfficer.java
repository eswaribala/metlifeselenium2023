package com.metlife.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClaimOfficer extends Employee{

    private boolean approval;

    //method overloading
    //compile time polymorphism

    public boolean claimApproval(Claim claim, PolicyHolder policyHolder) {

        long policyNo = claim.getPolicyNo();
        if (policyHolder.getPolicyNo() == policyNo) {
            if (policyHolder.getToDate().isAfter(LocalDate.now()))
                return true;
            else
                return false;
        }
        else
            return false;

    }
    public boolean claimApproval(PolicyHolder policyHolder) {


        if (policyHolder.getToDate().isAfter(LocalDate.now()))
                return true;
            else
                return false;
        }

}
