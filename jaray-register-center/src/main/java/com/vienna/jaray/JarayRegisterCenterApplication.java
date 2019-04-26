package com.vienna.jaray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer              //#启用注册中心
@SpringBootApplication
public class JarayRegisterCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarayRegisterCenterApplication.class, args);
	}

}
