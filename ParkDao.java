package com.techelevator.npgeek.model.site;

import java.util.List;

public interface ParkDao {


	public List<Park> getAllParks();
	
	public Park getParkById(String parkCode);

	
}
