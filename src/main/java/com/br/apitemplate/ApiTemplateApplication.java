package com.br.apitemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTemplateApplication.class, args);
	}

}
