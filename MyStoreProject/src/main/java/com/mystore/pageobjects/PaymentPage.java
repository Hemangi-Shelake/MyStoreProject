package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass{
	
	@FindBy(partialLinkText = "Pay by bank wi")
	WebElement bankWireMethod;
	
	@FindBy(partialLinkText = "Pay by che")
	WebElement payByCheckMethod;
	
	public PaymentPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public OrderSummary clickOnPaymentMethod()
	{
		Action.click(getDriver(), bankWireMethod);
		return new OrderSummary();
	}

}
