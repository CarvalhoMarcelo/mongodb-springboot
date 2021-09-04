package com.marcelo.mongodbspringboot.api.mappers;


import com.marcelo.mongodbspringboot.api.dtos.DepartmentDTO;
import com.marcelo.mongodbspringboot.api.entities.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDTO entityToDto(DepartmentEntity departmentEntity);

    List<DepartmentDTO> entityToDto(List<DepartmentEntity> departmentEntityList);

}
