package com.metlife.insuranceapi.services;

import com.metlife.insuranceapi.models.PolicyHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PolicyHolderService {

    private List<PolicyHolder> policyHolderList;

    public PolicyHolderService(){
        policyHolderList=new ArrayList<>();
    }

    public PolicyHolder addPolicyHolder(PolicyHolder policyHolder){
        policyHolderList.add(policyHolder);
        return policyHolder;
    }

    public List<PolicyHolder> getAllPolicyHolders(){
        return policyHolderList;
    }

}
