package com.example.vebdentalcare;

public class Patient {


    private String firstName;
    private String lastName;
    private String dob;
    private long mobileNo;
    private String imagePath;
    private String gender;

    public Patient(String firstName, String lastName, String dob, long mobileNo, String imagePath, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.mobileNo=mobileNo;
        this.imagePath = imagePath;
        this.gender = gender;
    }
    public String getDob() {
        return dob;
    }

    public void setDob(String age) {
        this.dob = dob;
    }
    public long getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(long mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }



    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }



    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
