package com.mystore.pageobjects;

import java.sql.Driver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class HomePage extends BaseClass{
	
	@FindBy(xpath = "//span[contains(text(),'My wishlists')]")
	WebElement myWishList;
	
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
	WebElement orderHistory;
	
	public HomePage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public boolean validateMyWishList()
	{
		return Action.isDisplayed(getDriver(), myWishList);
		
	}
	
	public boolean validateOrderHistory()

	{
		return Action.isDisplayed(getDriver(), orderHistory);
	}
	
	public String getCurrentURL()
	{
		String homePageURL=getDriver().getCurrentUrl();
		return homePageURL;
	}
}
