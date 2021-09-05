package com.marcelo.mongodbspringboot.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {

    private String userId;
    private String firstname;
    private String surname;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date birthDate;

    private String passport;
    private Integer departmentId;

}
