package com.learnautomation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestCaseWithoutFramework {

	@Test
	public void test1() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "D:\\My-Workspace\\Selenium\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/v4/");
		
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		driver.findElement(By.name("uid")).sendKeys("mngr47659");
		driver.findElement(By.name("password")).sendKeys("1@");
		
		driver.findElement(By.name("btnLogin")).click();
		
		Thread.sleep(2000);
		
		//This will quit the driver
		//This is commit 4
		driver.quit();
			
	}
		
}
