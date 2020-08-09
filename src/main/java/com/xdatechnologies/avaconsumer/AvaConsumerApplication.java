package com.xdatechnologies.avaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class AvaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AvaConsumerApplication.class, args);
	}

}
