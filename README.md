# WeatherForecast
Problem Statement: 
================
"As a user running the application  
I can view tomorrow’s predicted temperatures for a given zip-code in the *United States*
So that I know which will be the coolest hour of the day."

The outputs of this exercise should be a service that gets data from a weather service API and a client interface (could be CLI).  You can use any java framework of your choice.  

Goal is to get Forecast using OpenWeatherAPI and user provided Zipcode for Nth day from today

Solution:
=========
I have provided solution using following Technology stack:-
- Java
- Spring boot
- Spring MVC
- Spring RESTTemplate
- AES ENCRYPTION DECRYPTION
- MAVEN
- Git
- Github
- STS
- Junit

Application can be deployed as spring boot application providing 2 arguments as:- 

http://localhost:8080/weatherforecast/calculator?zip=29605&day=2

whereas zip is the zipcode of the city for forcast and day is day-from-today for which day of forcast to be calculated

example of the output for provided input argument will be printed in the console as:-

 # output==>YYYY-MM-DD Minimum Temp forcasted is ==> Temperature at 12:0:0 HRS

	Arguments to be passed to the the spring application are --zipcode=29605 --dayOfForcast=2
	where --zipcode is the zip code of the city whose temperature to be forecast
	--dayOfForcast is the day from today's date for which temperature needs to be forecast and should be less than 5 days

We have 2 service implementation to calculate weather forcast for provided zipcode and day from today's date by user namely:-
- WeatherForecastCalculatorServiceImpl
- WeatherForecastServiceImpl

We have Following Junits to test service layer functionality
- getWeatherForcastReport_OkResponse
- getWeatherForcastReport_InvalidZip
- getWeatherForcastReport_BadRequest
- getWeatherForcastReport_OkResponse
- getWeatherForcastReport_ThrowsException


We have Utililty classes
- to provide the global constant at service layer in the application
- to decrypt api keys


Technology Stack:-
=================
 - Java
 - Spring boot
 - Spring MVC
 - Spring RESTTemplate
 - AES ENCRYPTION DECRYPTION
 - MAVEN
 - Git
 - Github
 - STS
 - Junit

Build and Run:
==============
- step 1: mvn clean install
- step 2: mvn spring-boot:run -Dspring-boot.run.arguments="--zipcode=29605 --dayOfForcast=2"


Test Cases:
==========
- getWeatherForcastReport_OkResponse
- getWeatherForcastReport_InvalidZip
- getWeatherForcastReport_BadRequest
- getWeatherForcastReport_OkResponse
- getWeatherForcastReport_ThrowsException






