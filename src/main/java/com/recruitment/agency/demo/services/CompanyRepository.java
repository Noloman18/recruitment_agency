package com.recruitment.agency.demo.services;

import com.recruitment.agency.demo.model.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepository extends CrudRepository<Company,Long> {
}
