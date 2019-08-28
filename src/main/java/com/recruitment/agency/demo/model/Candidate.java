package com.recruitment.agency.demo.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate lastModificationDate;
    @OneToOne
    private Person personalDetails;
    @OneToMany
    private List<Company> workHistory;
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<Education> education;
}
