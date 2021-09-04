package com.marcelo.mongodbspringboot.api.repositories;

import com.marcelo.mongodbspringboot.api.entities.UserEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserEntity, Long> {

}
