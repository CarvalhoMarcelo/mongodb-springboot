package com.marcelo.mongodbspringboot.api.services.impl;

import com.marcelo.mongodbspringboot.api.dtos.UserDTO;
import com.marcelo.mongodbspringboot.api.entities.UserEntity;
import com.marcelo.mongodbspringboot.api.mappers.UserMapper;
import com.marcelo.mongodbspringboot.api.repositories.UserRepository;
import com.marcelo.mongodbspringboot.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Override
    public Optional<UserDTO> addUser(UserEntity userEntity) {

        try {
            return Optional.of(userMapper.entityToDto(userRepository.save(userEntity)));
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public boolean delUser(Long id) {

        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return false;
        }

        return true;

    }

    @Override
    public Optional<UserDTO> updateUser(UserEntity userEntity) {

        try {
            return Optional.of(userMapper.entityToDto(userRepository.save(userEntity)));
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public Optional<UserDTO> findById(Long id) {

        try {
            if(userRepository.findById(id).isPresent()){
                return Optional.of(userMapper.entityToDto(userRepository.findById(id).get()));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public List<UserDTO> findAll() {

        try{
            return userMapper.entityToDto(userRepository.findAll());
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return new ArrayList<>();
        }
    }




}
