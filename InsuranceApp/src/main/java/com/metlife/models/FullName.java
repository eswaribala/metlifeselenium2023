package com.metlife.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//user defined class type --- Embedded
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FullName {

    private String firstName;
    private String lastName;
    private String middleName;

}
