package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		
		this.driver = ldriver;
	}

	@FindBy(name = "uid") WebElement userID;
	@FindBy(name = "password") WebElement password;
	@FindBy(name = "btnLogin") WebElement loginBtn;
	
	public void loginToApp(String Username, String Password)
	{
		userID.sendKeys(Username);
		password.sendKeys(Password);
		loginBtn.click();
	}
	
}
