package com.innovecture.weatherforecast;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.innovecture.weatherforecast.entity.Example;
import com.innovecture.weatherforecast.service.IWeatherForecastCalculatorService;
import com.innovecture.weatherforecast.service.IWeatherForecastService;
import com.innovecture.weatherforecast.service.WeatherForecastCalculatorServiceImpl;

@SpringBootTest(classes = { WeatherForecastCalculatorServiceImpl.class })
@ExtendWith(SpringExtension.class)
public class WeatherForecastCalculatorServiceImplTest {

	@Autowired
	IWeatherForecastCalculatorService weatherForecastCalculatorService;

	@Test
	void contextLoads() {
	}

	@MockBean
	private IWeatherForecastService iWeatherForecastService;

	@Test
	public void getWeatherForcastReport_OkResponse() throws Exception {

		Example example = new Example();
		example.setCod(String.valueOf(HttpStatus.OK.value()));
		example.setList(new ArrayList());
		when(iWeatherForecastService.getWeatherForcastReport(26905, 1)).thenReturn(example);
		String consoleOutput = weatherForecastCalculatorService.getMinimumForcastForNthDay(26905, 1);
		assertNotEquals("", consoleOutput);
	}

	@Test
	public void getWeatherForcastReport_ThrowsException() throws Exception {

		Example example = new Example();
		example.setCod(String.valueOf(HttpStatus.BAD_REQUEST.value()));
		example.setList(new ArrayList());
		when(iWeatherForecastService.getWeatherForcastReport(26905, 1)).thenReturn(example);

		Assertions.assertThrows(RuntimeException.class, () -> {
			weatherForecastCalculatorService.getMinimumForcastForNthDay(26905, 1);
		});
	}

}
