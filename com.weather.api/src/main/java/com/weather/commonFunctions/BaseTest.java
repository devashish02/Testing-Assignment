package com.weather.commonFunctions;


import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
//import com.hobo.selenium.framework.Configuration;


public abstract class BaseTest {
	
	//WebDriver driver;
	public static ExtentReports extent;
	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	private static final String BREAK_LINE = "</br>";
	public static ExtentTest test;
	/*
	 * protected String userName; protected String password; protected String
	 * browserType; //private WebDriver driver; protected String applicationUrl;
	 * 
	 * // pages object initialization protected LoginPage loginPage; protected
	 * DashboardPage dashBoardPage;
	 * 
	 * enum DriverType { Firefox, IE, Chrome }
	 */

	
	/*
	 * public BaseTest(String browser) { this.browserType = browser; }
	 */

	@BeforeSuite
	public void before() {
		extent = new ExtentReports("target/surefire-reports/ExtentReport.html", true);
		 try {
		      //  RestAssured.port = port;
		        RestAssured.useRelaxedHTTPSValidation();
		        RestAssured.config().getSSLConfig().with().keyStore("classpath:keystore.p12", "password");
		    } catch (Exception ex) {
		        System.out.println("Error while loading keystore >>>>>>>>>");
		        ex.printStackTrace();
		    }
	}


	@AfterMethod(alwaysRun = true)
	public void afterMainMethod(ITestResult result) throws Exception{
		if (result.getStatus() == ITestResult.FAILURE) {
			//captureScreenshot(result);
			String methodname= result.getMethod().getMethodName();
			String classname= getClass().getName();
			System.out.println("CLASSNME: "+classname);
			String summary=	"ERROR IN: "+classname+ ":: "+methodname+ ":: "+result.getThrowable().getMessage().split("\\r?\\n")[0];
			System.out.println(summary);
			test.log(LogStatus.FAIL, summary);
			//driver.quit();
			//test.log(LogStatus.FAIL, result.getThrowable().getMessage());
			extent.endTest(test);
			extent.flush();
			
		}
		else{
			//driver.quit();
			//test.log(LogStatus.FAIL, result.getThrowable().getMessage());
			extent.endTest(test);
			extent.flush();
		}
		
		
	}
	
	@AfterSuite
	public void tearDownSuite() {
		//reporter.endReport();
		//driver.quit();
		extent.flush();
		extent.close();
	}
	/*
	 * @AfterSuite public void tearDownSuite() { // reporter.endReport(); }
	 */

//	public WebDriver getWebDriver() {
//		return driver;
//	}


	// Get absolute path
	public static String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}

	public void reportLog(String message) {
		// test.log(LogStatus.INFO, message);
		message = BREAK_LINE + message;
		logger.info("Message: " + message);
		Reporter.log(message);
	}

	// Creating file name
	public String getFileName(String file) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String fileName = file + dateFormat.format(cal.getTime());
		return fileName;
	}	
}