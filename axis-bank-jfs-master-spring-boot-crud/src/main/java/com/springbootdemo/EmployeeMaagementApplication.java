package com.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // @EnableConfiguration+ @Configuration +@ComponentScan
public class EmployeeMaagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMaagementApplication.class, args);
	}

}
