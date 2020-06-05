package com.medico.home.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigCloudServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigCloudServerApplication.class, args);
	}

}
