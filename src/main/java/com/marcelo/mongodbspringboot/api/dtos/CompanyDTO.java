package com.marcelo.mongodbspringboot.api.dtos;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDTO {

    private Long _id;
    private String name;
    private List<Object> list;

}
