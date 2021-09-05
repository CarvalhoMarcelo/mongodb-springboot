package com.marcelo.mongodbspringboot.api.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Users")
public class UserEntity {

    @Id
    private Long id;

    private String userId;
    private String password;
    private String name;
    private String surname;
    private Date birthDate;
    private String passport;
    private Long departmentId;


}
