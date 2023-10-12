package com.metlifews.bankapi.models;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "customer")
public class Customer {
 @JacksonXmlProperty(localName = "customerId")
 private long customerId;
 @JacksonXmlProperty(localName = "firstName")
 private String firstName;
 @JacksonXmlProperty(localName = "lastName")
 private String lastName;
 @JacksonXmlProperty(localName = "dob")
 private Date dob;
 @JacksonXmlProperty(localName = "mobileNo")
 private long mobileNo;


}
