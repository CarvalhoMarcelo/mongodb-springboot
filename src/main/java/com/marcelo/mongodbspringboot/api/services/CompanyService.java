package com.marcelo.mongodbspringboot.api.services;

import com.marcelo.mongodbspringboot.api.dtos.CompanyDTO;

import java.util.List;

public interface CompanyService {

    public List<CompanyDTO> listUsersByDepartment(Long id);

    public List<CompanyDTO> listDepartByUser(Long id);
}
