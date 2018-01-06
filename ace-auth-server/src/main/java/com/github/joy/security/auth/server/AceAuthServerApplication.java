package com.github.joy.security.auth.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@MapperScan("com.github.joy.security.auth.server.mapper")
@EnableAutoConfiguration
public class AceAuthServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceAuthServerApplication.class, args);
	}
}
