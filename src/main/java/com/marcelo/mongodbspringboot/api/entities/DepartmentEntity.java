package com.marcelo.mongodbspringboot.api.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Departments")
public class DepartmentEntity {

    @Id
    private Long id;
    private String name;

}
