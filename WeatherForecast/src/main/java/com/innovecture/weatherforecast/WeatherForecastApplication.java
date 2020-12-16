package com.innovecture.weatherforecast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

import com.innovecture.weatherforecast.service.IWeatherForecastCalculatorService;
import com.innovecture.weatherforecast.util.WeatherForecastConstants;

@SpringBootApplication
@ComponentScan("com.innovecture.weatherforecast")
public class WeatherForecastApplication /*implements ApplicationRunner*/ {

	private static final int ARG_INDEX = 0;

	private static final Logger logger = LoggerFactory.getLogger(WeatherForecastApplication.class);

	/*@Autowired
	IWeatherForecastCalculatorService weatherForecastCalculatorService;*/

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastApplication.class, args);
	}

/*	@Override
	public void run(ApplicationArguments args) throws Exception {

		Integer zipcode = Integer.parseInt(args.getOptionValues(WeatherForecastConstants.ZIPCODE).get(ARG_INDEX));
		Integer dayOfForecast = Integer.parseInt(args.getOptionValues(WeatherForecastConstants.DAY_OF_FORCAST).get(ARG_INDEX));
		String consoleOutput = weatherForecastCalculatorService.getMinimumForcastForNthDay(zipcode, dayOfForecast);
		logger.info("output==>" + consoleOutput);
	}
*/
}
