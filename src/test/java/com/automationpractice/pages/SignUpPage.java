package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

	@FindBy(id="inputfirstname4")
	public WebElement fnameField;
	
	@FindBy(id="inputlastname4")
	public WebElement lnameField;
	
	@FindBy(id="email")
	public WebElement emailField;
	
	@FindBy(id="exampleInputPassword1")
	public WebElement passwordField;
	
	@FindBy(id="register")
	public WebElement signUpButton;
}
