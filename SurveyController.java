package com.techelevator.npgeek.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.survey.Survey;
import com.techelevator.npgeek.model.survey.SurveyDao;
import com.techelevator.npgeek.model.survey.SurveyResult;
import com.techelevator.npgeek.model.survey.SurveyResultDao;


@Controller
public class SurveyController {
	
	@Autowired
	private SurveyDao dao;
	
	@Autowired
	private SurveyResultDao dao2;
	
	
	@RequestMapping("/survey")
	public String survey(ModelMap modelMap) {
		return "survey";
	}
	
	@RequestMapping(path="/newSurveyResponse", method=RequestMethod.POST)
	public String processSurveyResponse(@ModelAttribute Survey survey) {
		dao.save(survey);
		return "redirect:/surveyResults";
	}
	
	@RequestMapping("/surveyResults")
	public String surveyResults(ModelMap modelMap) {
		List<SurveyResult> allSurveys = dao2.getAllSurveyResults();
		modelMap.put("surveys", allSurveys);
		return "surveyResults";
	}
}
