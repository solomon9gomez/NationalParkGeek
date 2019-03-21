package com.techelevator.npgeek.model.survey;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcSurveyResultDao implements SurveyResultDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyResultDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
		}
	
	
	@Override
	public List<SurveyResult> getAllSurveyResults() {
		List<SurveyResult> allSurveys = new ArrayList<>();
		String sqlSelectAllSurveys = "\n" + 
				"SELECT COUNT(survey_result.parkcode) AS count, park.parkname, park.parkcode FROM survey_result \n" + 
				"JOIN park ON park.parkcode = survey_result.parkcode\n" + 
				"GROUP BY park.parkcode, survey_result.parkcode ORDER BY survey_result.parkcode";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllSurveys);
		while(results.next()) {
			SurveyResult survey = new SurveyResult();
			survey.setCount(results.getInt("count"));
			survey.setParkName(results.getString("parkname"));
			survey.setParkCode(results.getString("parkcode").toLowerCase());
			allSurveys.add(survey);
		}
		return allSurveys;
	}
	
	
}
