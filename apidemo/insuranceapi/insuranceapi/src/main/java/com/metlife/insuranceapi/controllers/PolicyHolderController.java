package com.metlife.insuranceapi.controllers;

import com.metlife.insuranceapi.models.PolicyHolder;
import com.metlife.insuranceapi.services.PolicyHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policyholders")
public class PolicyHolderController {
    @Autowired
    private PolicyHolderService policyHolderService;

    @PostMapping(value = "/v1.0/",produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<?> addPolicyHolder(@RequestBody PolicyHolder policyHolder){
        PolicyHolder policyHolderObj=policyHolderService.addPolicyHolder(policyHolder);
        if(policyHolderObj.getPolicyNo()>0){
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(policyHolderObj);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Policy Holder Not created");
        }

    }

    @GetMapping(value = "/v1.0/",produces = MediaType.APPLICATION_XML_VALUE)
    public List<PolicyHolder> getPolicyHolders(){
        return policyHolderService.getAllPolicyHolders();
    }


}
