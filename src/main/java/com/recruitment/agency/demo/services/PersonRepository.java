package com.recruitment.agency.demo.services;

import com.recruitment.agency.demo.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
}
