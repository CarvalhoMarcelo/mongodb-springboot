package com.marcelo.mongodbspringboot.api.services;

import com.marcelo.mongodbspringboot.api.dtos.UserDTO;
import com.marcelo.mongodbspringboot.api.entities.UserEntity;

import java.util.Optional;

public interface UsersService {

    public Optional<UserDTO> addUser(UserEntity userEntity);

}
