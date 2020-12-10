/**
 * 
 */
package com.innovecture.weatherforecast.service;

import com.innovecture.weatherforecast.entity.Example;

/**
 * @author zia.shaikh
 *
 */
public interface IWeatherForecastService {
	
	public Example getWeatherForcastReport(Integer zipcode,Integer dayOfForcast);

}
