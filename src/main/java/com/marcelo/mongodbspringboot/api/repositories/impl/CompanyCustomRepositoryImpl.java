package com.marcelo.mongodbspringboot.api.repositories.impl;

import com.marcelo.mongodbspringboot.api.dtos.CompanyDTO;
import com.marcelo.mongodbspringboot.api.repositories.CompanyCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import java.util.List;

public class CompanyCustomRepositoryImpl implements CompanyCustomRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public List<CompanyDTO> listUsersByDepartment(Long id) {
        LookupOperation lookup = LookupOperation.newLookup()
                .from("Users")
                .localField("_id")
                .foreignField("departmentId")
                .as("list");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(id)) , lookup);
        List<CompanyDTO> companyDTOList = mongoTemplate.aggregate(aggregation, "Departments", CompanyDTO.class).getMappedResults();

        return companyDTOList;
    }

    @Override
    public List<CompanyDTO> listDepartByUser(Long id) {
        LookupOperation lookup = LookupOperation.newLookup()
                .from("Departments")
                .localField("departmentId")
                .foreignField("_id")
                .as("list");

        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("_id").is(id)) , lookup);
        List<CompanyDTO> companyDTOList = mongoTemplate.aggregate(aggregation, "Users", CompanyDTO.class).getMappedResults();

        return companyDTOList;
    }

}
