package com.techelevator.npgeek.model.survey;

import java.util.List;

import com.techelevator.npgeek.model.survey.Survey;

public interface SurveyDao {
	
	public List<Survey> getAllSurveys();
	public void save(Survey survey);

}
