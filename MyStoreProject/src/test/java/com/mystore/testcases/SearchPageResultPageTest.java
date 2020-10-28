package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

public class SearchPageResultPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;

	
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
	
	@Test(groups = "Smoke")
	public void productAvailablityTest()
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		boolean result=searchResultPage.isProductAvailable();
		AssertJUnit.assertTrue(result);
	}
	
	

}
