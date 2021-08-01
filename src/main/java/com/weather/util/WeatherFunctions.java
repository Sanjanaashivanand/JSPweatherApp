package com.weather.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.weather.data.Data;

import org.json.JSONException;
import org.json.JSONArray;

public class WeatherFunctions {

	public Data getDetails() throws Exception{
		Data data = new Data();
		
		String API_KEY = ""; //Insert API key here
		String LOCATION = "bengaluru";
		String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + LOCATION + "&appid=" + API_KEY;
		
		try {
			StringBuffer result = new StringBuffer();
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();	
			BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line;
			while((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();
			
			//Converting the result to JSON
			try {
				JSONObject API_Response = new JSONObject(result.toString());
				String location = API_Response.getString("name");
				data.setLocation(location);
				JSONObject MainData =  API_Response.getJSONObject("main");
				int temp = (int)MainData.getLong("temp") - 273;
				data.setTemp(temp);
				JSONArray Weather =  API_Response.getJSONArray("weather");
				JSONObject Weather1 = Weather.getJSONObject(0);
				String weather = Weather1.getString("description");
				data.setDescription(weather);
				int id = Weather1.getInt("id");
				
				
				//Assigning icons
				if(id<300 && id>=200) {
					
					//Thunderstrom
					data.setSrcicon("https://image.flaticon.com/icons/png/128/1146/1146861.png");
				}
				else if(id<400 && id>=300) {
					
					//Drizzle
					data.setSrcicon("https://image.flaticon.com/icons/png/128/2675/2675876.png");
				}
				else if(id<600 && id>=500) {
					
					//Rain
					data.setSrcicon("https://image.flaticon.com/icons/png/128/826/826957.png");
				}
				else if(id<700 && id>=600) {
					
					//Snow
					data.setSrcicon("https://image.flaticon.com/icons/png/128/3026/3026312.png");
				}
				else if(id<=800 && id>=700) {
					
					//Atmosphere / Clear
					data.setSrcicon("https://image.flaticon.com/icons/png/128/2698/2698213.png");
				}
				else if(id<900 && id>800) {
					
					//Cloudy
					data.setSrcicon("https://image.flaticon.com/icons/png/128/1146/1146869.png");
				}
				
			
				
			}
			catch(JSONException e) {
				System.out.println(e.getMessage());
			}
			
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			data.setLocation("Not found!");
		}
		return data;
		
	}

}
