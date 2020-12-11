package com.api.test;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.weather.api.Exercise1Helper;
import com.weather.commonFunctions.BaseTest;
import com.weather.commonFunctions.CommonFunction;


public class Exercise1Test extends BaseTest {
	public Exercise1Test() throws Exception {
	}

	Exercise1Helper exercise1 = new Exercise1Helper();
	CommonFunction common = new CommonFunction();

	@Test(enabled = true, priority= 1)
	public void ToVerifyWeatherAPIFordataTypeAsrhrreadAndlangAsen() throws ParseException, IOException {
		
		test = extent.startTest("To Verify WeatherAPI For dataType As rhrread And lang As en");
		
		test.log(LogStatus.INFO, "Running Request with dataType As rhrread And lang As en and getting humidity data");
		String humiditydata= exercise1.getWeatherInformationHumidity("rhrread", "en");
		
		test.log(LogStatus.INFO, "validate the humiditydata response is not null");
		Assert.assertTrue(!humiditydata.isBlank(), "Error...!! Response is not successful..!!");
		
		test.log(LogStatus.INFO, "Running Request with dataType As rhrread And lang As en and getting temperature data");
		String temdata= exercise1.getWeatherInformationTemprature("rhrread", "en");
		
		test.log(LogStatus.INFO, "validate the temperaturedata response is not null");
		Assert.assertTrue(!temdata.isBlank(), "Error...!! Response is not successful..!!");
		
		test.log(LogStatus.INFO, "Running Request with dataType As rhrread And lang As en and getting rainfall data");
		String raidata= exercise1.getWeatherInformationRainfall("rhrread", "en");
		
		test.log(LogStatus.INFO, "validate the rainfall data response is not null");
		Assert.assertTrue(!raidata.isBlank(), "Error...!! Response is not successful..!!");
		
		test.log(LogStatus.INFO, "Running Request with dataType As rhrread And lang As en and getting icon data");
		String icndata= exercise1.getWeatherInformationIcon("rhrread", "en");
		
		test.log(LogStatus.INFO, "validate the icon data response is not null");
		Assert.assertTrue(!icndata.isBlank(), "Error...!! Response is not successful..!!");
		
		test.log(LogStatus.PASS, "To Verify WeatherAPI For dataType As rhrread And lang As en");
		//test.log(LogStatus.PASS, "To Verify humidity data is not null");
		test.log(LogStatus.PASS, "To Verify temperature data is not null");
		test.log(LogStatus.PASS, "To Verify rainfall data is not null");
		test.log(LogStatus.PASS, "To Verify icon data is not null");
		}
	
	
	
}