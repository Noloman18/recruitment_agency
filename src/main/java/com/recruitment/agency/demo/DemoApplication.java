package com.recruitment.agency.demo;


import com.recruitment.agency.demo.model.Candidate;
import com.recruitment.agency.demo.model.Person;
import com.recruitment.agency.demo.services.CandidateRespository;
import com.recruitment.agency.demo.services.PersonRepository;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Log
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CandidateRespository candidateRespository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        List<Person> people = DataGenerator.createPeople(10);
        people.stream().peek(person -> {
            personRepository.save(person);
			log.info("Finished saving person: " + person.toString());
        }).filter(DataGenerator::isAdult)
        .forEach(person-> {
            Candidate candidate = new Candidate();
            candidate.setPersonalDetails(person);
            candidate.setEducation(DataGenerator.generateEducation(person));
            candidate.setLastModificationDate(LocalDate.now());
            candidateRespository.save(candidate);
            log.info("Finished saving candidate: " + person.toString());
        });
    }
}
