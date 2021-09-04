package com.marcelo.mongodbspringboot.api.mappers;


import com.marcelo.mongodbspringboot.api.dtos.UserDTO;
import com.marcelo.mongodbspringboot.api.entities.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target="userId", source="id"),
            @Mapping(target="firstname", source="name"),
            @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    })
    UserDTO entityToDto(UserEntity userEntity);

    @Mappings({
            @Mapping(target="userId", source="id"),
            @Mapping(target="firstname", source="name"),
            @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd/MM/yyyy")
    })
    List<UserDTO> entityToDto(List<UserEntity> userEntityList);

}
