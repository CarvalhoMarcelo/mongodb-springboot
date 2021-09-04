package com.marcelo.mongodbspringboot.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class MongodbSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongodbSpringbootApplication.class, args);
	}

}
