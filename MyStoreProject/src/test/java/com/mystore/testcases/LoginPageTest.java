package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

public class LoginPageTest extends BaseClass{
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setUp(String browser) throws IOException
	{
		launchApplication(browser);
	}
	
	
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown()
	{
		getDriver().quit();
	}
	
	@Test(dataProvider = "credentials", dataProviderClass = DataProviders.class,groups = {"Smoke","Sanity"})
	public void loginTest(String uname, String pswd)
	{
		Log.startTestCase("Login Test");
		indexPage=new IndexPage();
		Log.info("User is going to click on Sign in");
		loginPage=indexPage.clickOnSignin();
		Log.info("Enter username and password");
		//homePage=loginPage.loginMethod(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.loginMethod(uname,pswd);

		String actualURL=homePage.getCurrentURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		AssertJUnit.assertEquals(actualURL, expectedURL);
		Log.info("Login is Success");
		Log.endTestCase("Login Test end");;
	}
	

}
