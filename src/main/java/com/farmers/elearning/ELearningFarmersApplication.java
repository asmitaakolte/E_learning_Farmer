package com.farmers.elearning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.farmers.elearning.model")
public class ELearningFarmersApplication {

	public static void main(String[] args) {
		SpringApplication.run(ELearningFarmersApplication.class, args);
	}

}
