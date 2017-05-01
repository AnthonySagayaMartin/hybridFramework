package com.actiTime.pageLibrary.loginPage;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.actiTime.testBase.TestBase;

public class LoginPage extends TestBase{
	
	public void ValidLogin() throws Exception
	{
	WebElement Username = getWebElement("actiTime.login.username");
	Reporter.log("Entering Username in Username field",true);
	Username.sendKeys(Repository.getProperty("userName"));
	
	
	WebElement Password = getWebElement("actiTime.login.password");
	Reporter.log("Entering Password in Password field",true);
	Password.sendKeys(Repository.getProperty("password"));
	
	WebElement Login = getWebElement("actiTime.login.LoginButton");
	Reporter.log("Clicking on Login",true);
	Login.click();
	driverwait(5);
	}
	
	public void invalidLogin() throws Exception
	{
		WebElement Username = getWebElement("actiTime.login.username");
		Username.sendKeys(Repository.getProperty("invalidusername"));
		
		WebElement Password = getWebElement("actiTime.login.password");
		Password.sendKeys(Repository.getProperty("invalidpassword"));
		
		WebElement Login = getWebElement("actiTime.login.LoginButton");
		Login.click();
	}

}
