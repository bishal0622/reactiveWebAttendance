package com.example.reactiveweb.demoreactiveweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class DemoreactivewebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoreactivewebApplication.class, args);
	}
}
