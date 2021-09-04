package com.marcelo.mongodbspringboot.api.controllers;

import com.marcelo.mongodbspringboot.api.dtos.UserDTO;
import com.marcelo.mongodbspringboot.api.entities.UserEntity;
import com.marcelo.mongodbspringboot.api.services.impl.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UsersController {


    @Autowired
    UsersServiceImpl usersServiceImpl;

    @RequestMapping(value = "/addUser",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> addUser(@RequestBody UserEntity userEntity) {

        if(usersServiceImpl.findById(userEntity.getId()).isPresent()){
            return new ResponseEntity("User id: " + userEntity.getId() + " already exist! Please use the updateUser method!",
                                       HttpStatus.NOT_ACCEPTABLE);
        }

        Optional<UserDTO> userDTO = usersServiceImpl.addUser(userEntity);

        if(userDTO.isEmpty()) {
            return new ResponseEntity("Error creating User!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(userDTO, HttpStatus.CREATED);
        }

    }

    @RequestMapping(value = "/updateUser",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserEntity userEntity) {

        if(usersServiceImpl.findById(userEntity.getId()).isEmpty()){
            return new ResponseEntity("User id: " + userEntity.getId() + " do not exist! Please use the addUser method!",
                    HttpStatus.NOT_ACCEPTABLE);
        }

        Optional<UserDTO> userDTO = usersServiceImpl.updateUser(userEntity);

        if(userDTO.isEmpty()) {
            return new ResponseEntity("Error updating User id: " + userEntity.getId(), HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity(userDTO, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/delUser",
                    method = RequestMethod.DELETE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> delUser(@Param("id") Long id) {

        if(usersServiceImpl.findById(id).isEmpty()){
            return new ResponseEntity("User id: " + id + " do not exist!",
                    HttpStatus.NOT_ACCEPTABLE);
        }

        if(!usersServiceImpl.delUser(id)) {
            return new ResponseEntity("Error deleting User!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("User with id: " + id + " successful deleted!", HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/findUser/{userId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserDTO> findUser(@PathVariable("userId") Long id) {

        Optional<UserDTO> userDTO = usersServiceImpl.findById(id);

        if(userDTO.isEmpty()) {
            return new ResponseEntity("User id: " + id + " not found!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(userDTO, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/listUsers",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<UserDTO>> listUsers() {

        List<UserDTO> userDTOList = usersServiceImpl.findAll();

        if(userDTOList.isEmpty()) {
            return new ResponseEntity("No Users found. List is empty!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(userDTOList, HttpStatus.OK);
        }

    }


}
