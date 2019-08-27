package com.recruitment.agency.demo.model;

import lombok.Data;

import lombok.extern.java.Log;

import javax.persistence.Embeddable;

@Embeddable
@Log
@Data
public class Address {
    private String street;
    private String suburb;
    private String city;
    private String postalCode;
    private String state;
}
