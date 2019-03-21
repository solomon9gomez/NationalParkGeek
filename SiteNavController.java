package com.techelevator.npgeek.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.site.Park;
import com.techelevator.npgeek.model.site.ParkDao;
import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDao;


@Controller
public class SiteNavController {
	
	@Autowired
	private ParkDao dao;
	
	@Autowired
	private WeatherDao dao2;
	
	@RequestMapping("/homePage")
	public String displayHomePage(ModelMap modelMap, HttpSession session) {
		List<Park> allParks = dao.getAllParks();
		modelMap.put("parks", allParks);
		session.setAttribute("cOrF", false);
		return "homePage";
	}

	@RequestMapping("/parkDetail")
	public String parkDetail(@RequestParam String parkCode, ModelMap modelMap) {
		modelMap.put("park", dao.getParkById(parkCode));
		return "parkDetail";
	}
	
	@RequestMapping("/weather")
	public String weatherPage(@RequestParam String parkCode, @RequestParam boolean tempCOrF, ModelMap modelMap, ModelMap modelMap2, HttpSession session) {
		List<Weather> allWeather = dao2.getWeather(parkCode);
		modelMap.put("weather", allWeather);
		modelMap2.put("park", dao.getParkById(parkCode));
		boolean temp = (boolean) session.getAttribute("cOrF");	
		session.setAttribute("cOrF", !temp);
		for (Weather a : allWeather) {
			a.tempSet(tempCOrF);
		}
		return "weather";
	}
}
