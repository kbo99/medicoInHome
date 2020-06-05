package com.medico.home.persona;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.medico.home.commons"})
public class PersonaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaServiceApplication.class, args);
	}

}
