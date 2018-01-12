package com.github.joy.security.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ace.cache.EnableAceCache;
import com.github.joy.security.auth.client.EnableAceAuthClient;

@SpringBootApplication
@EnableCircuitBreaker
@EnableAceAuthClient
@EnableFeignClients({"com.github.joy.security.auth.client.feign"})
@EnableScheduling
@EnableAceCache
@EnableTransactionManagement
public class AceAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AceAdminApplication.class, args);
	}
}
