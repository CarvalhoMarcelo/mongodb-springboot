package com.marcelo.mongodbspringboot.api.services;

import com.marcelo.mongodbspringboot.api.dtos.UserDTO;
import com.marcelo.mongodbspringboot.api.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UsersService {

    public Optional<UserDTO> addUser(UserEntity userEntity);

    public boolean delUser(Long id);

    public Optional<UserDTO> updateUser(UserEntity userEntity);

    public Optional<UserDTO> findById(Long id);

    public List<UserDTO> findAll();

}
