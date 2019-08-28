package com.recruitment.agency.demo.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Verification {
    private Boolean verified;
    private String verificationMethod;
}
