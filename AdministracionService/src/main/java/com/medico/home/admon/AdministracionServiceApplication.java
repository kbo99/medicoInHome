package com.medico.home.admon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
@EntityScan({"com.medico.home.commons"})
public class AdministracionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministracionServiceApplication.class, args);
	}

}
