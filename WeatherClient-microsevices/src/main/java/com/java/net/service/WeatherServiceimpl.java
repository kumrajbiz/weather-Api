package com.java.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.net.client.WeatherClient;
import com.java.net.entity.Weather;

@Service
public class WeatherServiceimpl implements WeatherService {
	

    
    @Autowired
    private WeatherClient weatherClient;

	public Weather[] getWeather(String location) {
        Weather[] response = weatherClient.getWeather(location);
		return response;
	}

	public Weather[] getWeatherByLocation(String location) {
		System.out.println("Service  "+location);
		Weather[] response = weatherClient.getWeatherByLocation(location);
		System.out.println(response.toString());
		System.out.println(response);
		return response;
	}

}
