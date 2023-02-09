package com.denizogut.movieserviceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.denizogut")
public class MovieServiceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieServiceAppApplication.class, args);
	}

}
