package com.mystore.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.mystore.actiondriver.Action;
import com.mystore.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	//public static WebDriver driver;
	
	public static ThreadLocal<RemoteWebDriver> driver=new ThreadLocal<>();
	
	@BeforeSuite(groups = {"Smoke","Sanity","Regression"})
	public void beforeSuite()
	{
		ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
	}
	
	public static WebDriver getDriver()
	{
		return driver.get();
	}
	
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void readConfig() throws IOException
	{
		prop=new Properties();
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"/Configuration/Config.properties");
		prop.load(fs);
	}
	
	
	public void launchApplication(String browserName) throws IOException
	{
		//readConfig();
		
		//String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//driver=new ChromeDriver();
			driver.set(new ChromeDriver());
		}
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//driver=new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}
		else if(browserName.equalsIgnoreCase("Safari"))
		{
			
			//driver=new SafariDriver();
			driver.set(new SafariDriver());
		}
		
		getDriver().manage().window().maximize();
		
		Action.implicitWait(getDriver(),10);
		
		Action.pageLoadTimeOut(getDriver(), 40);
		
		getDriver().get(prop.getProperty("url"));
		
	}
	
	@AfterSuite
	public void afterSuite()
	{
		ExtentManager.endReport();
	}

	
	
	

}
