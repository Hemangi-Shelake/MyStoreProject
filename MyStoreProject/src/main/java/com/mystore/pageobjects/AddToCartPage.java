package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass{
	
	@FindBy(xpath = "//input[@id='quantity_wanted']")
	WebElement quantity;
	
	@FindBy(css ="#group_1")
	WebElement size;
	
	@FindBy(xpath="//span[contains(text(),'Add to cart')]")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span")
	WebElement proceedToCheckOutBtn;
	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public void enterQuantity(String quantity1)
	{
		
		Action.type(quantity, quantity1);
	}
	
	public void selectSize(String size1)
	{
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart()
	{
		Action.fluentWait(getDriver(), addToCartBtn, 10);
		Action.JSClick(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddedToCart()
	{
		Action.fluentWait(getDriver(), addToCartMessag, 10);
		return Action.isDisplayed(getDriver(), addToCartMessag);
	}
	
	public OrderPage clickOnCheckOut()
	{
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}

}
