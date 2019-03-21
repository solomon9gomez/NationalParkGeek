package com.techelevator.npgeek.model.weather;

import java.util.List;

import com.techelevator.npgeek.model.site.Park;

public interface WeatherDao {
	
	public List<Weather> getWeather(String parkCode);	

//	public Weather getWeatherById(String parkCode);

}
