package com.innovecture.weatherforecast;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.innovecture.weatherforecast.entity.Example;
import com.innovecture.weatherforecast.service.IWeatherForecastService;
import com.innovecture.weatherforecast.service.WeatherForecastServiceImpl;

@SpringBootTest(classes = { WeatherForecastServiceImpl.class })
@ExtendWith(SpringExtension.class)
public class WeatherForecastServiceImplTest {

	@Autowired
	IWeatherForecastService weatherForecastServiceImpl;

	@Test
	void contextLoads() {
	}

	@Test
	public void getWeatherForcastReport_OkResponse() {

		Example example = weatherForecastServiceImpl.getWeatherForcastReport(29605, 1);
		assertEquals("" + HttpStatus.OK.value(), example.getCod());
	}

	@Test
	public void getWeatherForcastReport_InvalidZip() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			weatherForecastServiceImpl.getWeatherForcastReport(0, 1);
		});
	}

	@Test
	public void getWeatherForcastReport_BadRequest() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			weatherForecastServiceImpl.getWeatherForcastReport(null, null);
		});
	}

}
