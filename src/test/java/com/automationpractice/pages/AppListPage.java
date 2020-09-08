package com.automationpractice.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppListPage extends BasePage {
	
	@FindBy(xpath="//tbody//td[2]")
	public List<WebElement> borrowerNames;
	
	@FindBy(xpath="//tbody//td[3]")
	public List<WebElement> loanAmounts;
	
	
	
}
