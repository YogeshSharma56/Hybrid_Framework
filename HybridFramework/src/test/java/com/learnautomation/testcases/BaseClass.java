package com.learnautomation.testcases;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

//This is base class
public class BaseClass {
	
	WebDriver driver;
	ExcelDataProvider excel;
	ConfigDataProvider config;
	
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite()
	{
	excel = new ExcelDataProvider();
	config = new ConfigDataProvider();
	
	ExtentHtmlReporter reporter1 = new ExtentHtmlReporter(new File("./Reports/ExtentReport"+ Helper.getCurrentDateTime() +".html"));
	report = new ExtentReports();
	report.attachReporter(reporter1);
	
	
	}
	
	@Parameters({"browser", "applicationURL"})
	@BeforeClass
	public void setUp (String mybrowser, String appURL)
	{
		//driver = BrowserFactory.startApplication(driver, config.getBrowser(), config.getURL());
		
		driver = BrowserFactory.startApplication(driver, mybrowser, appURL);
	}
	
	
	@AfterClass
	public void tearDown() 
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void captureScreenshot(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
			// Helper.captureScreenshot(driver);
			logger.fail("Test case Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test case Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
	}
	
	
}
