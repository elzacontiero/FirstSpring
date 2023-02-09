package com.sparta.firstspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This annotation tells Spring this is the entry point, the Spring Main.
public class FirstspringApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstspringApplication.class, args);
	}

}
