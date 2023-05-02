package com.java.net.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.java.net.entity.Weather;

@FeignClient(name = "WeatherMapAPIv2", url = "http://localhost:9090")
public interface WeatherClient {
	
//	@RequestMapping(value = "/weather/{location}", method = RequestMethod.GET)
//	public Weather[] getWeather(@PathVariable("location") String loaction);
	
	@RequestMapping(value = "/weather/{location}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String getWeatherByLocation(@PathVariable("location") String loaction);

}
