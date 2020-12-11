package com.weather.commonFunctions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Scanner;

import org.json.simple.JSONObject;



public class CommonFunction {

	/**
	 * This method will return Random number as per user desirable length.
	 * @param numberLength
	 * @return
	 */
	public static int getRandomNumber(int numberLength) {
		StringBuilder sb = new StringBuilder(numberLength);
		final String strg = "0123456789";
		SecureRandom rndm = new SecureRandom();
		for (int i = 0; i < numberLength; i++)
			sb.append(strg.charAt(rndm.nextInt(strg.length())));
		return Integer.parseInt(sb.toString());
	}
	
	public void deleteTextFile(String filepath) {
		 File file = new File(filepath);
	        if(file.delete()){
	            System.out.println("Text File for Session Id is deleted");
	        }else System.out.println("Text file doesnt exist");
	}
	
	public void createNewFileAndEnterText(String filepath, String textToBeEntered) throws IOException {
		File file = new File(filepath);
		  
		//Create the file
		if (file.createNewFile())
		{
		    System.out.println("File is created!");
		} else {
		    System.out.println("File already exists.");
		}
		 
		//Write Content
		FileWriter writer = new FileWriter(file);
		writer.write(textToBeEntered);
		writer.close();
	}
	
	public String readTextFromFile(String filepath) throws IOException {
		File file = new File(filepath);
		Scanner scan = new Scanner(file);  
		scan.useDelimiter("\\Z");  
		String content = scan.next(); 
		return content;
	}
	
	public JSONObject updateJsonFile(JSONObject json, String keyToBeUpdated, String valueToUpdate) throws IOException {
		 json.remove(keyToBeUpdated);
		 json.put(keyToBeUpdated, valueToUpdate);
		 return json;
	}

	
	
	
	
}
