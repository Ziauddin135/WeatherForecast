/**
 * 
 */
package com.innovecture.weatherforecast.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.innovecture.weatherforecast.entity.Example;

/**
 * @author zia.shaikh
 *
 */
@Service
public class WeatherForecastServiceImpl implements IWeatherForecastService {

	private static final Logger logger = LoggerFactory.getLogger(WeatherForecastServiceImpl.class);

	@Value("${openweather.forecast.url}")
	private String url;

	@Value("${openweather.forecast.apiAccessKey}")
	private String apiAccessKey;

	@Override
	public Example getWeatherForcastReport(Integer zipcode, Integer dayOfForcast) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url).queryParam("appid", apiAccessKey)
				.queryParam("zip", zipcode);

		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<Example> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				Example.class);

		try {
			response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, Example.class);

		} catch (HttpClientErrorException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e.getMessage());
		}
		return response.getBody();
	}

}
