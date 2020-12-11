package com.weather.api;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;

import com.weather.commonFunctions.CommonFunction;
import com.weather.commonFunctions.ReadTextFile;

import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Exercise2Helper {
	
	boolean flag=false; 
	public Exercise2Helper() throws Exception {
	}

	String HOME_URL = ReadTextFile.readApplicationFile("ApiURL");
	CommonFunction common = new CommonFunction();
        
			
			public int ExecuteBinaryFileAndGetReult() throws IOException, InterruptedException {
			
					String filepath = System.getProperty("user.dir") + "/" +  "test.BAT";
					
					Runtime run = Runtime.getRuntime(); // Process execution
					Process proc = run.exec(filepath);
					int response = proc.waitFor();
					return response;
			}
			
			public int sendHttpRequetWhenBinaryIsExecuted() throws IOException {
				String endpoint = "https://api.github.com"; // API for testing
					URL url = new URL(endpoint);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					con.setRequestMethod("GET"); // GET request
					int res = con.getResponseCode(); // Receive status code
					System.out.println("It Works "+ res);
					return res;
			
					
				
			}
			
			
}