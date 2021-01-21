package com.example.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(DemoApplication.class, args);
	}


}
