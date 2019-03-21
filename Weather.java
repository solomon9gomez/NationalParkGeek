package com.techelevator.npgeek.model.weather;

public class Weather {
	
	private String parkCode;
	private int fiveDayForcastValue;
	private int low;
	private int high;
	private String forecast;
	private String advice;
	private String tempAdvice;
	private boolean cOrF;
	
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForcastValue() {
		return fiveDayForcastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForcastValue) {
		this.fiveDayForcastValue = fiveDayForcastValue;
	}
	public int getLow() {
		return low;
	}
	public void setLow(int low) {
		this.low = low;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public String getAdvice() {
		return advice;
	}
	public void setAdvice(String advice) {
		this.advice = advice;
	}
	public String getTempAdvice() {
		return tempAdvice;
	}
	public void setTempAdvice(String tempAdvice) {
		this.tempAdvice = tempAdvice;
	}
	public void setCOrF(boolean cOrF) {
		this.cOrF = cOrF;
	}
	public boolean getCOrF() {
		return cOrF;
	}
	
public Weather createAdvice(Weather weather) {
		
		String forecast = weather.getForecast();
		if (forecast.equals("rain")) {
			weather.setAdvice("Pack rain gear and wear waterproof shoes.");
		}
		if (forecast.equals("snow")) {
			weather.setAdvice("Pack snowshoes.");
		}
		if (forecast.equals("thunderstorms")) {
			weather.setAdvice("Seek shelter and avoid hiking on exposed ridges.");
		}
		if (forecast.equals("sunny")) {
			weather.setAdvice("Pack sunblock.");
		}
		return weather;
	}
	
	public Weather createTempAdvice(Weather weather) {
		int low = weather.getLow();
		int high = weather.getHigh();
		if (high - low > 20) {
			weather.setTempAdvice("Wear breathable layers.");
		}
		if (high > 75) {
			weather.setTempAdvice("Bring an extra gallon of water.");
		}
		if (low < 20) {
			weather.setTempAdvice("Beware of frostbite and hypothermia due to prolonged exposure to frigid temperatures.");
		}
		
		return weather;
	}

	public int tempToCelsius(int temp) {
		int cTemp = (((temp - 32) * 5)/9);
		
		return cTemp;
	}

	public boolean tempSet(boolean cOrF) {
		if (cOrF == true) {
			low = tempToCelsius(low);
			high = tempToCelsius(high);
		}
		return cOrF;
	}

}



