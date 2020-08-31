package com.medico.home.not;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.medico.home.not.model"})
public class NotificacionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacionServiceApplication.class, args);
	}

}
