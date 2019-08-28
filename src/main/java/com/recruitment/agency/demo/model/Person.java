package com.recruitment.agency.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String title;
    private String name;
    private String middleName;
    private String surname;
    private String gender;
    private LocalDate birthDate;
    @Embedded
    private ContactDetails currentContactDetails;
}
