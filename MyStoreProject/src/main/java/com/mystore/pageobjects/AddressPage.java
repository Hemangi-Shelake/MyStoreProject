package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass{
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
	WebElement proceedToChekout;
	
	public AddressPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public ShippingPage ClickOnCheckout()
	{
		Action.click(getDriver(), proceedToChekout);
		return new ShippingPage();
	}

}
