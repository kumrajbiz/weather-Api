package com.java.net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class WeatherMapApIv2MocroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherMapApIv2MocroserviceApplication.class, args);
	}

}
