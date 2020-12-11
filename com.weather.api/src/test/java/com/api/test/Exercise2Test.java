package com.api.test;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.weather.api.Exercise1Helper;
import com.weather.api.Exercise2Helper;
import com.weather.commonFunctions.BaseTest;
import com.weather.commonFunctions.CommonFunction;


public class Exercise2Test extends BaseTest {
	public Exercise2Test() throws Exception {
	}

	Exercise2Helper exercise2 = new Exercise2Helper();
	CommonFunction common = new CommonFunction();

	@Test(enabled = true, priority= 1)
	public void ToVerifyBinaryFile() throws ParseException, IOException, InterruptedException {
		
		test = extent.startTest("To Verify Endpoint url when binary is executed");
		
		test.log(LogStatus.INFO, "To Verify Endpoint url when binary is executed");
		int processcode= exercise2.ExecuteBinaryFileAndGetReult();
		
		test.log(LogStatus.INFO, "To Assert if process is executed");
		Assert.assertTrue(processcode==0, "Error...!! Binary file is not executed..!!"); // successful process execution
		
		test.log(LogStatus.INFO, "To Verify Endpoint url when binary is executed");
		int responseFromHTTPexecution= exercise2.sendHttpRequetWhenBinaryIsExecuted();
		
		test.log(LogStatus.INFO, "To Assert if process is executed");
		Assert.assertTrue(responseFromHTTPexecution==200, "Error...!! Response is not successful..!!");
		
		
		test.log(LogStatus.PASS, "It Works");
		
		}
	
	
	
}