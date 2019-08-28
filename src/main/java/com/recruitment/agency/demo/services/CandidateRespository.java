package com.recruitment.agency.demo.services;

import com.recruitment.agency.demo.model.Candidate;
import org.springframework.data.repository.CrudRepository;

public interface CandidateRespository extends CrudRepository<Candidate,Long> {
}
