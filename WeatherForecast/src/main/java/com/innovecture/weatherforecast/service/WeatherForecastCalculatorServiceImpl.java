/**
 * 
 */
package com.innovecture.weatherforecast.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.innovecture.weatherforecast.entity.Example;
import com.innovecture.weatherforecast.entity.List;
import com.innovecture.weatherforecast.util.WeatherForecastConstants;

/**
 * @author zia.shaikh
 *
 */
@Service
public class WeatherForecastCalculatorServiceImpl implements IWeatherForecastCalculatorService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherForecastCalculatorServiceImpl.class);

	@Autowired
	IWeatherForecastService weatherForecastServiceImpl;

	@Override
	public String getMinimumForcastForNthDay(Integer zipcode, Integer dayOfForecast) throws Exception {
		Example apiresponse = weatherForecastServiceImpl.getWeatherForcastReport(zipcode, dayOfForecast);
		Double minTemp = null;
		LocalDate today = LocalDate.now();
		LocalDateTime cooleastHour = null;
		if (apiresponse.getCod().equals(String.valueOf(HttpStatus.OK.value()))) {
			LocalTime midnight = LocalTime.MIDNIGHT;
			LocalDateTime todayMidnight = LocalDateTime.of(today, midnight);
			LocalDateTime nthDayMidnight = todayMidnight.plusDays(dayOfForecast);
			LocalDateTime nthplusDayMidnight = todayMidnight.plusDays(dayOfForecast + 1);

			for (List perDayForecast : apiresponse.getList()) {

				LocalDateTime dt = LocalDateTime.parse(perDayForecast.getDtTxt(),
						DateTimeFormatter.ofPattern(WeatherForecastConstants.YYYY_MM_DD_HH_MM_SS));
				if ((nthDayMidnight.isBefore(dt) || nthDayMidnight.equals(dt)) && nthplusDayMidnight.isAfter(dt)) {
					if (minTemp == null
							|| (minTemp.doubleValue() > perDayForecast.getMain().getTempMin().doubleValue())) {
						minTemp = perDayForecast.getMain().getTempMin();
						cooleastHour = dt;
						logger.info("perDayForecast Json==>" + perDayForecast.getDtTxt());
						logger.info("minTemp of the day: " + minTemp);
						logger.info("coolest hour of the day: " + cooleastHour);
					}
				}
			}
		} else {
			logger.error("API returns with error in response");
			throw new RuntimeException("API returns with error in response");
		}

		String hour = cooleastHour != null ? "" + cooleastHour.getHour() : "";
		String min = cooleastHour != null ? "" + cooleastHour.getMinute() : "";
		String sec = cooleastHour != null ? "" + cooleastHour.getSecond() : "";

		return today.plusDays(dayOfForecast) + " Minimum Temp forcasted is ==>" + minTemp + " at " + hour + ":" + min
				+ ":" + sec + " HRS";
	}

}
