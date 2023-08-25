package com.example.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// The main Spring Boot application class automatically scans the package and sub-packages, including everything within the "com.example.springcoredemo" package. If the packages are outside, we should configure the "SpringBootApplication" annotation to explicitly list the base packages to scan.
@SpringBootApplication(
		scanBasePackages = {"componentScanDemo.common",
							"componentScanDemo.rest"})

public class SpringcoredemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcoredemoApplication.class, args);
	}

}
