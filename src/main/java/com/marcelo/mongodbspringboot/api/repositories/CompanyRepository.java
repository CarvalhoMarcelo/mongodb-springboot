package com.marcelo.mongodbspringboot.api.repositories;

import com.marcelo.mongodbspringboot.api.dtos.CompanyDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CompanyRepository extends MongoRepository<CompanyDTO, Long>, CompanyCustomRepository  {

}
