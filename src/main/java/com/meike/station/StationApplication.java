package com.meike.station;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class StationApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationApplication.class, args);
	}
}
