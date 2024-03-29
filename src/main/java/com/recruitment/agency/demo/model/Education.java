package com.recruitment.agency.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String institutionName;
    private String description;
    private String category;
    private LocalDate enrollmentDate;
    private LocalDate graduationDate;
    @Embedded
    private Verification verification;
}
