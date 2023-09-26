package com.metlife.models;
import java.time.LocalDate;

public class PolicyHolder {
    //properties
    //primitive data types
    private long policyNo;
    private LocalDate fromDate;
    private LocalDate toDate;
    private FullName name;
    private Gender gender;
    private LocalDate dob;
    private String email;
    private Address address;
    private long phoneNo;

    public long getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(long policyNo) {
        this.policyNo = policyNo;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public FullName getName() {
        return name;
    }

    public void setName(FullName name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }
}
