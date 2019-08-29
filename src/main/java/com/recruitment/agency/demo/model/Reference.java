package com.recruitment.agency.demo.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Data
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String description;
    @OneToOne
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Person reference;
    @Embedded
    private Verification verification;
}
