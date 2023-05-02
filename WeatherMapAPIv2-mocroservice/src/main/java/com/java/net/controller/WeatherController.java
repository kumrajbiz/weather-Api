package com.java.net.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.net.entity.Weather;
import com.java.net.service.WeatherService;

@CrossOrigin
@RestController
@RequestMapping
public class WeatherController {
	
	@Autowired
	private WeatherService  weatherService;

    @RequestMapping("/weather/{location}")
    public Weather[] current(@PathVariable String location) {
        return weatherService.currentService(location);
    }

  

}