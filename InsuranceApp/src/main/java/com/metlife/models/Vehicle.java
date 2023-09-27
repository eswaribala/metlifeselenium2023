package com.metlife.models;

import lombok.Data;

import java.time.LocalDate;
@Data
public class Vehicle {

    private String registrationNo;
    private String maker;
    private LocalDate dor;
    private String chassisNo;
    private String engineNo;
    private Fuel fuel;
    private String color;
}
