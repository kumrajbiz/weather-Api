package com.java.net.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.net.client.WeatherClient;
import com.java.net.entity.Weather;

@Service
public class WeatherServiceimpl implements WeatherService {
	

    
    @Autowired
    private WeatherClient weatherClient;

//	public Weather[] getWeather(String location) {
//        Weather[] response = weatherClient.getWeather(location);
//		return response;
//	}

	public String getWeatherByLocation(String location) {
		System.out.println("Service  "+location);
		String response = weatherClient.getWeatherByLocation(location);
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonResponse = null;
		try {
			jsonResponse = objectMapper.writeValueAsString(objectMapper.readValue(response, Object.class));
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(response.toString());
		System.out.println(response);
		return jsonResponse;
	}

}
