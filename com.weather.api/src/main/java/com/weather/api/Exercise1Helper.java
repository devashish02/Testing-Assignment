package com.weather.api;

import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.weather.commonFunctions.CommonFunction;
import com.weather.commonFunctions.ReadTextFile;
import com.weather.commonFunctions.ReadValueFromJson;

import io.restassured.RestAssured;
import io.restassured.config.SSLConfig;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Exercise1Helper {
	
	boolean flag=false; 
	public Exercise1Helper() throws Exception {
	}

	String HOME_URL = ReadTextFile.readApplicationFile("ApiURL");
	CommonFunction common = new CommonFunction();
        
     	   
			//Login with empty user name
			@SuppressWarnings("deprecation")
			public String getWeatherInformationHumidity(String dataTypeValue, String langValue) throws ParseException 
			{
				
				String humiditydata = "";
				
					RestAssured.baseURI = HOME_URL;
					RequestSpecification httpRequest = RestAssured.given();
					Response response=httpRequest.request(Method.GET, "?dataType="+dataTypeValue+"&lang="+langValue);
					
					String responseBody = response.getBody().asString();
					JsonPath jsonPathEvaluator = response.jsonPath();
					humiditydata = jsonPathEvaluator.get("humidity.data[0].place");
					
					
				      System.out.println(responseBody);
					
					  System.out.println("Humidity Data from Response: "+ humiditydata);
					  int responsecode = response.getStatusCode();
					  System.out.println("response code is "+ responsecode);
					
					Assert.assertTrue(response.getStatusCode()==200, "Error...!! Response is not successful..!!");
					
					return humiditydata;
			
			}
			
			public String getWeatherInformationTemprature(String dataTypeValue, String langValue) throws ParseException 
			{
				
				String tempdata = "";
				
					RestAssured.baseURI = HOME_URL;
					RequestSpecification httpRequest = RestAssured.given();
					Response response=httpRequest.request(Method.GET, "?dataType="+dataTypeValue+"&lang="+langValue);
					
					String responseBody = response.getBody().asString();
					JsonPath jsonPathEvaluator = response.jsonPath();
					tempdata = jsonPathEvaluator.get("temperature.data[1].unit");
					
				      System.out.println(responseBody);
					
					  System.out.println("Temperature Data from Response: "+ tempdata);
					  int responsecode = response.getStatusCode();
					  System.out.println("response code is "+ responsecode);
					
					Assert.assertTrue(response.getStatusCode()==200, "Error...!! Response is not successful..!!");
					
					return tempdata;
			
			}
			
			public String getWeatherInformationRainfall(String dataTypeValue, String langValue) throws ParseException 
			{
				
				String raindata = "";
				
					RestAssured.baseURI = HOME_URL;
					RequestSpecification httpRequest = RestAssured.given();
					Response response=httpRequest.request(Method.GET, "?dataType="+dataTypeValue+"&lang="+langValue);
					
					String responseBody = response.getBody().asString();
					JsonPath jsonPathEvaluator = response.jsonPath();
					raindata = jsonPathEvaluator.get("rainfall.data[0].max").toString();
					
				      System.out.println(responseBody);
					
					  System.out.println("Rainfall Data from Response: "+ raindata);
					  int responsecode = response.getStatusCode();
					  System.out.println("response code is "+ responsecode);
					
					Assert.assertTrue(response.getStatusCode()==200, "Error...!! Response is not successful..!!");
					
					return raindata;
			
			}
			
			public String getWeatherInformationIcon(String dataTypeValue, String langValue) throws ParseException 
			{
				
				String icondata = "";
				
					RestAssured.baseURI = HOME_URL;
					RequestSpecification httpRequest = RestAssured.given();
					Response response=httpRequest.request(Method.GET, "?dataType="+dataTypeValue+"&lang="+langValue);
					
					String responseBody = response.getBody().asString();
					JsonPath jsonPathEvaluator = response.jsonPath();
					icondata = jsonPathEvaluator.get("icon").toString();
					
				      System.out.println(responseBody);
					
					  System.out.println("Icon Data from Response: "+ icondata);
					  int responsecode = response.getStatusCode();
					  System.out.println("response code is "+ responsecode);
					
					Assert.assertTrue(response.getStatusCode()==200, "Error...!! Response is not successful..!!");
					
					return icondata;
			
			}
			
			
}