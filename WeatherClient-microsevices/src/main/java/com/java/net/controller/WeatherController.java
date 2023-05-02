package com.java.net.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.net.entity.Weather;
import com.java.net.service.WeatherServiceimpl;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:9099/")// for allowing react service to allow access
public class WeatherController {

   
    @Autowired
    private WeatherServiceimpl weatherService;
    
//    @GetMapping("/home")
//    public String homePage(Model model) {
//    	System.out.println("inside homePage controller");
//        return "index";
//    }

    @GetMapping("/{location}")
    public Weather[] getWeather(@PathParam("location") String location) {
//        String url = "http://openweathermap/forecast?location=" + location;

        return null;
    }
    
    
    @GetMapping("/weather/{location}")
    public ResponseEntity<String> getWeatherByLocation(@PathVariable("location") String location) {
    	System.out.println("controoler  "+location);
    	String weather = weatherService.getWeatherByLocation(location);
    	return ResponseEntity.ok(weather);
    	
    }
}
