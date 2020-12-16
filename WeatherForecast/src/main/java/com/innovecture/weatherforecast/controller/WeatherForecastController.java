package com.innovecture.weatherforecast.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovecture.weatherforecast.exception.ResourceNotFoundException;
import com.innovecture.weatherforecast.exception.WeatherForecastServiceException;
import com.innovecture.weatherforecast.service.IWeatherForecastCalculatorService;

@RestController
@RequestMapping("weatherforecast")
public class WeatherForecastController {
	
	
	
	@Autowired
	IWeatherForecastCalculatorService weatherForecastCalculatorService;
	
	
	
	
	@GetMapping("calculator/{zipcode}/{dayOfForecast}")
	public  ResponseEntity<String>  getForeCastDetails(@PathVariable("zipcode")	Integer zipcode
			, @PathVariable("dayOfForecast") Integer dayOfForecast) throws ResourceNotFoundException , WeatherForecastServiceException {
		String response = "";
		
		
		try {
			response =	weatherForecastCalculatorService.getMinimumForcastForNthDay(zipcode, dayOfForecast);
			
			if (response == null) {
				throw new ResourceNotFoundException("Data not found");
			}
			return  new ResponseEntity<String>(response, HttpStatus.OK);
		}catch (Exception e) {
			
			throw new WeatherForecastServiceException("Internal Server Exception"); 
		}
		

	}
		
		
	
		
		
		
	}
	
	
	


