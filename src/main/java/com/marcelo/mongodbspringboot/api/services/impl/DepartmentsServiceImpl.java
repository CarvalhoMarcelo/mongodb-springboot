package com.marcelo.mongodbspringboot.api.services.impl;

import com.marcelo.mongodbspringboot.api.dtos.DepartmentDTO;
import com.marcelo.mongodbspringboot.api.entities.DepartmentEntity;
import com.marcelo.mongodbspringboot.api.mappers.DepartmentMapper;
import com.marcelo.mongodbspringboot.api.repositories.DepartmentRepository;
import com.marcelo.mongodbspringboot.api.services.DepartmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class DepartmentsServiceImpl implements DepartmentsService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    DepartmentMapper departmentMapper;

    @Override
    public Optional<DepartmentDTO> addDepartment(DepartmentEntity departmentEntity) {

        try {
            return Optional.of(departmentMapper.entityToDto(departmentRepository.save(departmentEntity)));
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public boolean delDepartment(Long id) {

        try {
            departmentRepository.deleteById(id);
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return false;
        }

        return true;

    }

    @Override
    public Optional<DepartmentDTO> updateDepartment(DepartmentEntity departmentEntity) {

        try {
            return Optional.of(departmentMapper.entityToDto(departmentRepository.save(departmentEntity)));
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public Optional<DepartmentDTO> findById(Long id) {

        try {
            if(departmentRepository.findById(id).isPresent()){
                return Optional.of(departmentMapper.entityToDto(departmentRepository.findById(id).get()));
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return Optional.empty();
        }

    }

    @Override
    public List<DepartmentDTO> findAll() {

        try{
            return departmentMapper.entityToDto(departmentRepository.findAll());
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
            return new ArrayList<>();
        }
    }




}
