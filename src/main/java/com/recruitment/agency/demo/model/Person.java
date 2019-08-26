package com.recruitment.agency.demo.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String middleName;
    private String surname;
    private LocalDate birthDate;
    @Embedded
    private ContactDetails contactDetails;
}
