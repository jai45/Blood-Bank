package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class BloodBankClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodBankClientApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
	@Bean
	
	public WebClient.Builder builder(){
		return WebClient.builder();
	}
	
	@Bean
	public WebClient client(WebClient.Builder builderRef) {
		return builderRef.build();
	}
}
