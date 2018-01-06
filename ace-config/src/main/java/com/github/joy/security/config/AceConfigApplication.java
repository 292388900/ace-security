package com.github.joy.security.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableAutoConfiguration
@EnableEurekaClient
@EnableConfigServer
public class AceConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceConfigApplication.class, args);
	}
}
