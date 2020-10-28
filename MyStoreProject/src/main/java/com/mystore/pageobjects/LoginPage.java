package com.mystore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class LoginPage extends BaseClass{
	
	@FindBy(id = "email")
	WebElement userName;
	
	@FindBy(name = "passwd")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;
	
	@FindBy(id = "email_create")
	WebElement emailforNewAccount;
	
	@FindBy(name = "SubmitCreate")
	WebElement createNewAccountBtn;
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage loginMethod(String uname, String pwd)
	{
		Action.type(userName, uname);
		Action.type(password, pwd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();
	}
	
	public AddressPage loginMethod1(String uname, String pwd)
	{
		Action.type(userName, uname);
		Action.type(password, pwd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewAccount(String newEmail)
	{
		Action.type(emailforNewAccount, newEmail);
		Action.click(getDriver(), createNewAccountBtn);
		return new AccountCreationPage();
	}
	

}
