package com.techelevator.npgeek.model.site;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.npgeek.model.site.Park;
import com.techelevator.npgeek.model.site.ParkDao;

@Component
public class JdbcParkDao implements ParkDao{
		
		private JdbcTemplate jdbcTemplate;
		
		@Autowired
		public JdbcParkDao(DataSource dataSource) {
			this.jdbcTemplate = new JdbcTemplate(dataSource);
		}

		@Override
		public List<Park> getAllParks() {
			ArrayList<Park> parks = new ArrayList<>();
			Park thePark = null;
			String sqlgetAllParks = "SELECT * FROM park";
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlgetAllParks);
			while (results.next()) {
				thePark = mapRowToPark(results);
				parks.add(thePark);
			}
			return parks;
		}

		@Override
		public Park getParkById(String parkCode) {
			Park thePark = null;
			String sqlFindParkById = "SELECT * FROM park WHERE parkcode = ?";
			SqlRowSet result = jdbcTemplate.queryForRowSet(sqlFindParkById, parkCode.toUpperCase());
		
			if( result.next()) {
			thePark = mapRowToPark(result);
			}
			
			return thePark;
		}

		private Park mapRowToPark(SqlRowSet results) {
			Park thePark;
			thePark = new Park();
			thePark.setParkCode(results.getString("parkcode").toLowerCase());
			thePark.setParkName(results.getString("parkname"));
			thePark.setState(results.getString("state"));
			thePark.setAcreage(results.getInt("acreage"));
			thePark.setElevationInFeet(results.getInt("elevationinfeet"));
			thePark.setMilesOfTrail(results.getDouble("milesoftrail"));
			thePark.setClimate(results.getString("climate"));
			thePark.setYearFounded(results.getInt("yearfounded"));
			thePark.setAnnualVisitorCount(results.getInt("annualvisitorcount"));
			thePark.setInspirationalQuote(results.getString("inspirationalquote"));
			thePark.setInspirationalQuoteSource(results.getString("inspirationalquotesource"));
			thePark.setParkDescription(results.getString("parkdescription"));
			thePark.setEntryFee(results.getInt("entryfee"));
			thePark.setNumberOfAnimalSpecies(results.getInt("numberofanimalspecies"));

			
			return thePark;
		}
		
		
}
