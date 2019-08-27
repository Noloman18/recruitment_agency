package com.recruitment.agency.demo.model;

import lombok.Data;
import lombok.extern.java.Log;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Log
@Data
public class ContactDetails {
    private String email;
    private String mobilePhone;
    private String homePhone;
    @Embedded
    private Address physicalAddress;
}
