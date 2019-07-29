package com.healthdom.HealthdomDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class HealthdomDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthdomDemoApplication.class, args);
	}

}
