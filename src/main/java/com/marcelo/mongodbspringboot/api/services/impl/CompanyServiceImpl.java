package com.marcelo.mongodbspringboot.api.services.impl;

import com.marcelo.mongodbspringboot.api.dtos.CompanyDTO;
import com.marcelo.mongodbspringboot.api.repositories.CompanyRepository;
import com.marcelo.mongodbspringboot.api.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;



    @Override
    public List<CompanyDTO> listUsersByDepartment(Long id) {

        return companyRepository.listUsersByDepartment(id);

    }

    @Override
    public List<CompanyDTO> listDepartByUser(Long id) {

        return companyRepository.listDepartByUser(id);

    }

}
