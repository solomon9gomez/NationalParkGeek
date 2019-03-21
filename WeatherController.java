package com.techelevator.npgeek.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.weather.Weather;
import com.techelevator.npgeek.model.weather.WeatherDao;


@Controller
public class WeatherController {
	
	
	@Autowired
	private WeatherDao dao2;
	
	
	public String tempPreference(ModelMap modelMap, HttpSession session) {
		session.setAttribute("cOrF", "C");
		return null;
	}
}
