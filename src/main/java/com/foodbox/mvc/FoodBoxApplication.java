package com.foodbox.mvc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;


@SpringBootApplication
public class FoodBoxApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodBoxApplication.class, args);
	}

}
