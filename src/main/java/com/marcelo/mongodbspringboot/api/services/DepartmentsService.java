package com.marcelo.mongodbspringboot.api.services;

import com.marcelo.mongodbspringboot.api.dtos.DepartmentDTO;
import com.marcelo.mongodbspringboot.api.entities.DepartmentEntity;

import java.util.Optional;

public interface DepartmentsService {

    public Optional<DepartmentDTO> addDepartment(DepartmentEntity departmentEntity);

}
