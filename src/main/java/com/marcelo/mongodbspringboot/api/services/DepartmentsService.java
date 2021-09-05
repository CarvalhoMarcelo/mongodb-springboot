package com.marcelo.mongodbspringboot.api.services;

import com.marcelo.mongodbspringboot.api.dtos.DepartmentDTO;
import com.marcelo.mongodbspringboot.api.entities.DepartmentEntity;

import java.util.List;
import java.util.Optional;

public interface DepartmentsService {

    public Optional<DepartmentDTO> addDepartment(DepartmentEntity departmentEntity);

    public boolean delDepartment(Long id);

    public Optional<DepartmentDTO> updateDepartment(DepartmentEntity departmentEntity);

    public Optional<DepartmentDTO> findById(Long id);

    public List<DepartmentDTO> findAll();

}
