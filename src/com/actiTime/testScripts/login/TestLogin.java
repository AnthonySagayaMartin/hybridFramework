package com.actiTime.testScripts.login;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.actiTime.pageLibrary.loginPage.LoginPage;
import com.actiTime.testBase.TestBase;

public class TestLogin extends TestBase{
	
	@Test(priority='1')
	public void testLogin() throws Exception
	{
		LoginPage lp=new LoginPage();
		lp.ValidLogin();
		
	}
	
}
