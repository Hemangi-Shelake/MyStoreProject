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
import com.mystore.pageobjects.IndexPage;

public class IndexPageTest extends BaseClass{
	
	IndexPage indexPage;
	
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
	public void verifyLogo()
	{
		indexPage=new IndexPage();
		
		boolean result=indexPage.validateLogo();
		AssertJUnit.assertTrue(result);
	}
	
	@Test(groups = "Smoke")
	public void verifyTitle()
	{
		String title=indexPage.getMyStoreTitle();
		AssertJUnit.assertEquals(title, "My Store");
	}
	

}
