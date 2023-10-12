package com.metlife.insuranceapi.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "PolicyHolder")
public class PolicyHolder {
    @JacksonXmlProperty(localName = "PolicyNo")
    private long policyNo;
    @JacksonXmlProperty(localName = "FirstName")
    private String firstName;
    @JacksonXmlProperty(localName = "LastName")
    private String lastName;
    @JacksonXmlProperty(localName = "DOB")
    private Date dob;
    @JacksonXmlProperty(localName = "MobileNo")
    private long mobileNo;

}
