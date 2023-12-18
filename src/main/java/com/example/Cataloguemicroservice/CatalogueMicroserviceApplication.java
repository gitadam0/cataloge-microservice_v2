package com.example.Cataloguemicroservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Slf4j
@EnableMongoRepositories
public class CatalogueMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogueMicroserviceApplication.class, args);
		System.out.println(" Catalogue Microservice is running...");
		//System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
 