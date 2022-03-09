package com.company.growzoneservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class GrowZoneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowZoneServiceApplication.class, args);
	}

}
