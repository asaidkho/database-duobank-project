package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.Driver;


public class BasePage {

	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id="exampleInputEmail1")
	public WebElement loginEmail;
	
	@FindBy(id="exampleInputPassword1")
	public WebElement loginPassword;
	
	@FindBy(name="login")
	public WebElement loginButton;
	
	@FindBy(xpath="//span[.='Application List']")
	public WebElement appListLink;
	
	
}
