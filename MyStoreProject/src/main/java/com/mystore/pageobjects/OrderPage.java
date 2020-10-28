package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass{
	
	@FindBy(xpath = "//*[@id=\"product_price_1_1_0\"]/span")
	WebElement unitPrice;
	
	@FindBy(xpath = "//span[@id='total_price']")
	WebElement totalPrice;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
	WebElement proceedToCheckOut;
	
	public OrderPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public double getUnitPrice()
	{
		String price=unitPrice.getText();
		String unit=price.replaceAll("[^a-zA-Z0-9]", "");
		double finalUnitPrice=Double.parseDouble(unit);
		return finalUnitPrice/100;
	}
	
	public double getUTotalPrice()
	{
		String tPrice=totalPrice.getText();
		String unit1=tPrice.replaceAll("[^a-zA-Z0-9]", "");
		double finalTotalPrice=Double.parseDouble(unit1);
		return finalTotalPrice/100;
	}
	
	public LoginPage clickOnCheckOut()
	{
		Action.click(getDriver(), proceedToCheckOut);
		return new LoginPage();
	}

}
