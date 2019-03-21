package com.techelevator.npgeek.model.weather;

import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.site.Park;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDao;

@Component
public class JdbcWeatherDao implements WeatherDao{
		
		private JdbcTemplate jdbcTemplate2;
		
		@Autowired
		public JdbcWeatherDao(DataSource dataSource) {
			this.jdbcTemplate2 = new JdbcTemplate(dataSource); 
			}

		@Override
		public List<Weather> getWeather(String parkCode) {
			ArrayList<Weather> weather = new ArrayList<>();
			Weather theWeather = null;
			String sqlgetWeather = "SELECT * FROM weather WHERE parkcode = ?";
			SqlRowSet results = jdbcTemplate2.queryForRowSet(sqlgetWeather, parkCode.toUpperCase());
			while (results.next()) {
				theWeather = mapRowToWeather(results);
				theWeather.createAdvice(theWeather);
				theWeather.createTempAdvice(theWeather);
				weather.add(theWeather);
				
			}
			return weather;
		}

		private Weather mapRowToWeather(SqlRowSet results) {
			Weather theWeather;
			theWeather = new Weather();
			theWeather.setParkCode(results.getString("parkcode").toLowerCase());
			theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
			theWeather.setLow(results.getInt("low"));
			theWeather.setHigh(results.getInt("high"));
			theWeather.setForecast(results.getString("forecast").replace("partly cloudy", "partlyCloudy"));
			theWeather.setCOrF(false);
	
			return theWeather;
		}
	
}
