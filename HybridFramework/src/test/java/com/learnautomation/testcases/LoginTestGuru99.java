package com.learnautomation.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class LoginTestGuru99 extends BaseClass {	
	
	//This is First Test Case
	//This is before taking pull
	@Test
	public void loginGuru99 ()
	{
		logger =report.createTest("Login to app");
		
		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);	
		logger.info("Test Started !!");
		
		loginpage.loginToApp(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		
	}

}
