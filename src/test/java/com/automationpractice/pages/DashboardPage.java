package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

	@FindBy(xpath="//*[@id=\"main-menu-navigation\"]//li[2]/a")
	public WebElement applicationList;
	
	
	@FindBy(xpath="//*[@id=\"DataTables_Table_0\"]//a")
	public WebElement viewDetails;
	
	
}
