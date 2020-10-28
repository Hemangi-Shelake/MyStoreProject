package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass{
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li/div/div[1]/div/a[1]/img")
	WebElement productResult;
	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean isProductAvailable()
	{
		return Action.isDisplayed(getDriver(), productResult);
	}
	
	public AddToCartPage clickOnProduct()
	{
		//Action.fluentWait(driver, productResult, 20);
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
	}

}
