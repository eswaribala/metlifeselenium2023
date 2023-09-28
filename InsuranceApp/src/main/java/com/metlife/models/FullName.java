package com.metlife.models;

import com.metlife.exceptions.FirstNameNotMatchingException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.regex.Pattern;

//user defined class type --- Embedded
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FullName {

    private String firstName;
    private String lastName;
    private String middleName;


    public void setFirstName(String firstName) {
        String patterValue="[A-Za-z]{5,25}";
       Pattern pattern=Pattern.compile(patterValue);
        if(pattern.matcher(firstName).matches())

          this.firstName = firstName;
        else
            throw new FirstNameNotMatchingException("First Name should be only in alphabets and the range is 5 to 15");

    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
