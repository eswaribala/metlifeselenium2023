package com.metlife.models;

import lombok.Data;

@Data
public class Claim extends Loss implements Report{
    private long policyNo;
    private Vehicle vehicle;


}
