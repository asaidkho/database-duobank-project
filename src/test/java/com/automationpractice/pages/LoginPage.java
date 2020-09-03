package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.automationpractice.utilities.ConfigReader;


public class LoginPage extends BasePage{

	@FindBy(linkText = "Sign up")
	public WebElement signupLink;
	
	@FindBy(id = "exampleInputEmail1")
	public WebElement emailInput;
	
	@FindBy(id = "exampleInputPassword1")
	public WebElement passwordInput;
	
	@FindBy(tagName = "button")
	public WebElement loginButton;
	
	
	public void login() {
		emailInput.sendKeys(ConfigReader.getProperty("username"));
		passwordInput.sendKeys(ConfigReader.getProperty("password"));
		loginButton.click();
	}
}
