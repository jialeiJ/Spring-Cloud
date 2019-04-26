package com.vienna.jaray;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer     //启动配置中心服务
@EnableDiscoveryClient  //配置中心高可用
@SpringBootApplication
public class JarayConfigCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarayConfigCenterApplication.class, args);
	}

}
