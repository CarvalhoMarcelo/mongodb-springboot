package com.marcelo.mongodbspringboot.api.repositories;

import com.marcelo.mongodbspringboot.api.dtos.CompanyDTO;

import java.util.List;

public interface CompanyCustomRepository {

    List<CompanyDTO> listUsersByDepartment(Long id);

    List<CompanyDTO> listDepartByUser(Long id);

}
