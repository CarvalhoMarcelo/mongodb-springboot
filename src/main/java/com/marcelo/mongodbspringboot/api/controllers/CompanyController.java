package com.marcelo.mongodbspringboot.api.controllers;

import com.marcelo.mongodbspringboot.api.dtos.CompanyDTO;
import com.marcelo.mongodbspringboot.api.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @RequestMapping(value = "/listUsersByDepartment/{departmentId}")
    @ResponseBody
    public List<CompanyDTO> listUsersByDepartment(@PathVariable("departmentId") Long id){

        List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();

        companyDTOList.addAll(companyService.listUsersByDepartment(id));
        return companyDTOList;

    }

    @RequestMapping(value = "/listDepartByUser/{userId}")
    @ResponseBody
    public List<CompanyDTO> listDepartByUser(@PathVariable("userId") Long id){

        List<CompanyDTO> companyDTOList = new ArrayList<CompanyDTO>();

        companyDTOList.addAll(companyService.listDepartByUser(id));
        return companyDTOList;

    }




}
