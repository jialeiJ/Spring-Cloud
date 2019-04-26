package com.vienna.jaray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class JarayGatewayCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarayGatewayCenterApplication.class, args);
	}

}
