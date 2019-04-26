package com.vienna.jaray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceProviderTwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProviderTwoApplication.class, args);
	}

}
