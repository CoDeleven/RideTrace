package com.studio701.routebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RoutebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutebookApplication.class, args);
	}
}
