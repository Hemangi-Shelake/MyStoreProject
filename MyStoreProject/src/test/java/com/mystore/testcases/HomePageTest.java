package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

public class HomePageTest extends BaseClass{
	
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
	
	@Test(groups = "Sanity")
	public void wishListTest()
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignin();
		homePage=loginPage.loginMethod(prop.getProperty("username"), prop.getProperty("password"));
		Boolean result=homePage.validateMyWishList();
		Assert.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void orderHistoryAndDetailsTest()
	{
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignin();
		homePage=loginPage.loginMethod(prop.getProperty("username"), prop.getProperty("password"));
		Boolean result=homePage.validateOrderHistory();
		Assert.assertTrue(false);
	}

}
