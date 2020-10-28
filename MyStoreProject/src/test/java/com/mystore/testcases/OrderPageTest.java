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
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

public class OrderPageTest extends BaseClass{
	
	IndexPage indexPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
    OrderPage orderPage;
	
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
	
	@Test(groups = "Regression")
	public void verifyTotalPrice()
	{
		indexPage=new IndexPage();
		searchResultPage=indexPage.searchProduct("t-shirt");
		addToCartPage=searchResultPage.clickOnProduct();
		//Thread.sleep(3000);
		addToCartPage.enterQuantity("2");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		Double unitPrice=orderPage.getUnitPrice();
		Double totalPrice=orderPage.getUTotalPrice();
		
		Double totalExpectedPrice=(unitPrice)+2;
		AssertJUnit.assertEquals(totalPrice, totalExpectedPrice);
	}

}
