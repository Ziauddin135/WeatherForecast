/**
 * 
 */
package com.innovecture.weatherforecast.service;

/**
 * @author zia.shaikh
 *
 */
public interface IWeatherForecastCalculatorService {

	public String getMinimumForcastForNthDay(Integer zipcode, Integer dayOfForecast) throws Exception;
}
