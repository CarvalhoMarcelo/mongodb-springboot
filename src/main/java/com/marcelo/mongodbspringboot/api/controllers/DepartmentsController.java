package com.marcelo.mongodbspringboot.api.controllers;

import com.marcelo.mongodbspringboot.api.dtos.DepartmentDTO;
import com.marcelo.mongodbspringboot.api.entities.DepartmentEntity;
import com.marcelo.mongodbspringboot.api.services.DepartmentsService;
import com.marcelo.mongodbspringboot.api.services.impl.DepartmentsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/department")
public class DepartmentsController {


    @Autowired
    DepartmentsService departmentsService;

    @RequestMapping(value = "/addDepartment",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<DepartmentDTO> addDepartment(@RequestBody DepartmentEntity departmentEntity) {

        if(departmentsService.findById(departmentEntity.getId()).isPresent()){
            return new ResponseEntity("Department id: " + departmentEntity.getId() + " already exist! Please use the updateDepartment method!",
                                       HttpStatus.NOT_ACCEPTABLE);
        }

        Optional<DepartmentDTO> departmentDTO = departmentsService.addDepartment(departmentEntity);

        if(departmentDTO.isEmpty()) {
            return new ResponseEntity("Error creating Department!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(departmentDTO, HttpStatus.CREATED);
        }

    }

    @RequestMapping(value = "/updateDepartment",
                    method = RequestMethod.PUT,
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<DepartmentDTO> updateDepartment(@RequestBody DepartmentEntity departmentEntity) {

        if(departmentsService.findById(departmentEntity.getId()).isEmpty()){
            return new ResponseEntity("Department id: " + departmentEntity.getId() + " do not exist! Please use the addDepartment method!",
                    HttpStatus.NOT_ACCEPTABLE);
        }

        Optional<DepartmentDTO> departmentDTO = departmentsService.updateDepartment(departmentEntity);

        if(departmentDTO.isEmpty()) {
            return new ResponseEntity("Error updating Department id: " + departmentEntity.getId(), HttpStatus.NOT_MODIFIED);
        } else {
            return new ResponseEntity(departmentDTO, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/delDepartment",
                    method = RequestMethod.DELETE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<DepartmentDTO> delDepartment(@Param("id") Long id) {

        if(departmentsService.findById(id).isEmpty()){
            return new ResponseEntity("Department id: " + id + " do not exist!",
                    HttpStatus.NOT_ACCEPTABLE);
        }

        if(!departmentsService.delDepartment(id)) {
            return new ResponseEntity("Error deleting Department!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity("Department with id: " + id + " successful deleted!", HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/findDepartment/{departmentId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<DepartmentDTO> findDepartment(@PathVariable("departmentId") Long id) {

        Optional<DepartmentDTO> departmentDTO = departmentsService.findById(id);

        if(departmentDTO.isEmpty()) {
            return new ResponseEntity("Department id: " + id + " not found!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(departmentDTO, HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/listDepartments",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<DepartmentDTO>> listDepartments() {

        List<DepartmentDTO> departmentDTOList = departmentsService.findAll();

        if(departmentDTOList.isEmpty()) {
            return new ResponseEntity("No Departments found. List is empty!", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity(departmentDTOList, HttpStatus.OK);
        }

    }


}
