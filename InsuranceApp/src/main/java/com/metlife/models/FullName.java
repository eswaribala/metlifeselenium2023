package com.metlife.models;

import lombok.Data;

//user defined class type --- Embedded
@Data
public class FullName {

    private String firstName;
    private String lastName;
    private String middleName;

}
