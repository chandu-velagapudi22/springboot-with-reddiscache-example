package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringbootWithReddiscacheExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWithReddiscacheExampleApplication.class, args);
		System.out.println("WEelcome chandu");
	}

}
