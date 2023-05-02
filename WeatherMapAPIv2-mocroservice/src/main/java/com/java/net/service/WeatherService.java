package com.java.net.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.java.net.entity.Weather;

@Service
public class WeatherService {
	private final String URL ="https://api.openweathermap.org/data/2.5/forecast?q=";
	private final String APPID="d2929e9483efc82c82c32ee7e02d563e";

	public Weather[] currentService(String location) {
		String content;
		String Count = "1";
        try {
            URL obj = new URL( URL + location + "&appid=" + APPID+"&cnt="+Count);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();
            content = response.toString();
        } catch (Exception e) {
            System.out.print("ERROR : " + e.getMessage());
            e.printStackTrace();
            return null;
        }

        Weather[] weatherList = new Weather[Integer.parseInt(Count)];

        for (int i = 0; i < weatherList.length; i++) {
            
            JSONObject root = new JSONObject(content);
            JSONArray list = root.getJSONArray("list");
            JSONObject city = root.getJSONObject("city");
            JSONObject currentObj = list.getJSONObject(i);
            JSONObject main = currentObj.getJSONObject("main");
            JSONObject wind = currentObj.getJSONObject("wind");
            JSONObject weather = currentObj.getJSONArray("weather").getJSONObject(0);

            Weather tempWeat = new Weather(
                    weather.getString("description"),   
                    city.getString("country"),          
                    city.getString("name"),             
                    main.getInt("temp"),                
                    main.getInt("temp_min"),            
                    main.getInt("temp_max"),            
                    main.getInt("humidity"),            
                    main.getInt("pressure"),           
                    wind.getInt("deg"),                 
                    wind.getInt("speed")                
            );
            weatherList[i] = tempWeat;
        }
		return weatherList;
	}
}
