package com.actiTime.testScripts.login;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.actiTime.pageLibrary.loginPage.LoginPage;
import com.actiTime.testBase.TestBase;

public class TestInvalidLogin extends TestBase{
	
	@Test
	public void testInvalidLogin1() throws Exception
	{
		LoginPage lp=new LoginPage();
		lp.invalidLogin();
		
	}

}
