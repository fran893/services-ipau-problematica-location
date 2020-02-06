package com.app.ipau.problematica.location;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.app.ipau.commons.problematicas.models.entities",
	"com.app.ipau.commons.problematica.location.models.entities"})
public class ServicesIpauProblematicaLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicesIpauProblematicaLocationApplication.class, args);
	}

}
