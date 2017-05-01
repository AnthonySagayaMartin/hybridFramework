package com.actiTime.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.actiTime.testUtils.Utills;

public class TestBase extends Utills{
	
	public static Properties Repository = new Properties();
	public File F;
	public FileInputStream FI;
	
	@BeforeClass
	public void init() throws IOException
	{
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		impliciteWait(2);
		driver.get(Repository.getProperty("url"));
		
		
	}
	
	
	public void loadPropertiesFile() throws IOException
	{
		F=new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\config\\config.properties");
		FI= new FileInputStream(F);
		Repository.load(FI);
		
		F=new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\loginPage.properties");
		FI= new FileInputStream(F);
		Repository.load(FI);
		
		F=new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\reportsPage.properties");
		FI= new FileInputStream(F);
		Repository.load(FI);
		
		F=new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\taskPage.properties");
		FI= new FileInputStream(F);
		Repository.load(FI);
		
		F=new File(System.getProperty("user.dir")+"\\src\\com\\actiTime\\pageLocators\\timeTracks.properties");
		FI= new FileInputStream(F);
		Repository.load(FI);
		
		
	}
	
	public static WebElement getLocator(String locator) throws Exception
	
	{
		String locatorType=locator.split("_")[0];
		String locatorValue=locator.split("_")[1];
		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
		
	public WebElement getWebElement(String locator) throws Exception
	{
		return getLocator(Repository.getProperty(locator));
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	}
	
	

