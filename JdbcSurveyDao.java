package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyDao implements SurveyDao{
	
	private JdbcTemplate jdbcTemplate;
	
	
	
	@Autowired
	public JdbcSurveyDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
		}
	
	
	
	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "\n" + 
				"SELECT COUNT(survey_result.parkcode), park.parkname FROM survey_result \n" + 
				"JOIN park ON park.parkcode = survey_result.parkcode\n" + 
				"GROUP BY park.parkcode, survey_result.parkcode ORDER BY survey_result.parkcode";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) {
			
			
			/*Survey survey = new Survey();
			survey.setSurveyId(results.getInt("surveyid"));
			survey.setParkCode(results.getString("parkcode").toLowerCase());
			survey.setEmailAddress(results.getString("emailaddress"));
			survey.setState(results.getString("state"));
			survey.setActivityLevel(results.getString("activitylevel"));
			allSurveys.add(survey);*/
		}
		return allSurveys;
	}
	
	//public String getParkName() {

		//String sqlForParkName = "SELECT parkname FROM park WHERE parkcode = " + results.getString("parkcode").toUpperCase();
		//SqlRowSet result = jdbcTemplate.queryForRowSet(sqlForParkName);
		
		//survey.setParkName(result.getString("parkname"));
	//}

	@Override
	public void save(Survey survey) {
		int surveyId = getNextSurveyId();
		String sqlInsertSurvey = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertSurvey, surveyId, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
		survey.setSurveyId(surveyId);
	}

	private int getNextSurveyId() {
		String sqlSelectNextSurveyId = "SELECT NEXTVAL('seq_surveyid')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextSurveyId);
		int id = 0;
		if(results.next()) {
			id = results.getInt(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next survey id from sequence");
		}
		return id;
	}

	

}
