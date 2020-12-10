package com.innovecture.weatherforecast;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.innovecture.weatherforecast.entity.Example;
import com.innovecture.weatherforecast.service.WeatherForecastServiceImpl;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class WeatherForecastServiceImplTest {
	
	@Autowired
	WeatherForecastServiceImpl weatherForecastServiceImpl;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void getWeatherForcastReport_OkResponse() {
		
		Example example = weatherForecastServiceImpl.getWeatherForcastReport(29605, 1);
		 assertEquals("200", example.getCod());		
	}
	
	@Test
	public void getWeatherForcastReport_InvalidZip() {
		
		Example example = weatherForecastServiceImpl.getWeatherForcastReport(0, 1);
		 assertEquals("400", example.getCod());		
	}
	
	@Test
	public void getWeatherForcastReport_InvalidDayOfForcast() {
		
		Example example = weatherForecastServiceImpl.getWeatherForcastReport(29605, 5);
		 assertEquals("400", example.getCod());		
	}
	
	@Test
	public void getWeatherForcastReport_BadRequest() {
		
		Example example = weatherForecastServiceImpl.getWeatherForcastReport(null, null);
		 assertEquals("400", example.getCod());		
	}
	
}
