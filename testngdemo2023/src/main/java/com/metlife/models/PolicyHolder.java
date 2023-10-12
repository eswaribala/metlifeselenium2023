package com.metlife.models;

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
    @JacksonXmlProperty(localName = "policyNo")
    private long policyNo;
    @JacksonXmlProperty(localName = "firstName")
    private String firstName;
    @JacksonXmlProperty(localName = "lastName")
    private String lastName;
    @JacksonXmlProperty(localName = "dob")
    private Date dob;
    @JacksonXmlProperty(localName = "mobileNo")
    private long mobileNo;

}
