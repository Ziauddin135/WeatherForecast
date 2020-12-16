package com.innovecture.weatherforecast.exception;

public class WeatherForecastServiceException extends Exception {
	
	
	private static final long serialVersionUID = -470180507998010368L;
	
	public WeatherForecastServiceException() {
		
		super();
	}
	
	public WeatherForecastServiceException(final String message) {
		super(message);
	}

}
