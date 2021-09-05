package com.marcelo.mongodbspringboot.api.controllers;

import com.marcelo.mongodbspringboot.api.dtos.CompanyDTO;
import com.marcelo.mongodbspringboot.api.dtos.DepartmentDTO;
import com.marcelo.mongodbspringboot.api.dtos.UserDTO;
import com.marcelo.mongodbspringboot.api.services.CompanyService;
import com.marcelo.mongodbspringboot.api.services.DepartmentsService;
import com.marcelo.mongodbspringboot.api.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    DepartmentsService departmentsService;

    @Autowired
    UsersService usersService;


    @RequestMapping(value = "/listUsersByDepartment/{departmentId}")
    @ResponseBody
    public List<CompanyDTO> listUsersByDepartment(@PathVariable("departmentId") Long id){


        Optional<DepartmentDTO> departmentDTO = departmentsService.findById(id);
        if(departmentDTO.isEmpty()) {
            return new ArrayList<>();
        }

        List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();

        companyDTOList.addAll(companyService.listUsersByDepartment(id));
        return companyDTOList;

    }

    @RequestMapping(value = "/listDepartByUser/{userId}")
    @ResponseBody
    public List<CompanyDTO> listDepartByUser(@PathVariable("userId") Long id){

        Optional<UserDTO> userDTO = usersService.findById(id);
        if(userDTO.isEmpty()) {
            return new ArrayList<>();
        }

        List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();

        companyDTOList.addAll(companyService.listDepartByUser(id));
        return companyDTOList;

    }




}
