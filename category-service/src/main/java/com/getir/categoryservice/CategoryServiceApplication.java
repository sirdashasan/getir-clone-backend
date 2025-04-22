package com.getir.categoryservice;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CategoryServiceApplication {


	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.load(); //
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));
		SpringApplication.run(CategoryServiceApplication.class, args);
	}

}
