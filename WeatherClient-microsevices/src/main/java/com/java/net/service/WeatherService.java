package com.java.net.service;

import java.util.List;

import com.java.net.entity.Weather;

public interface WeatherService {

	//public Weather[] getWeather(String location);
	
	public String getWeatherByLocation(String location);
}
