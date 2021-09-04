package com.marcelo.mongodbspringboot.api.repositories;

import com.marcelo.mongodbspringboot.api.entities.DepartmentEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<DepartmentEntity, Long> {

}
