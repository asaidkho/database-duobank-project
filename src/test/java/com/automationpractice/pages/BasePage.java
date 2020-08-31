package com.automationpractice.pages;

import org.openqa.selenium.support.PageFactory;

import com.automationpractice.utilities.Driver;

public class BasePage {

	public BasePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
}
