package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{

	@FindBy(xpath="//*[@id=\"main-menu-navigation\"]//li[2]/a")
	public WebElement applicationList;
	
	
	//@FindBy(xpath="//*[@id=\"DataTables_Table_0\"]//a")
	//public WebElement viewDetails;
	//@FindBy(xpath="//*[@id=\"DataTables_Table_0\"]/tbody/tr[2]/td[4]/a")
	///public WebElement viewDetails;

   @FindBy(xpath="//tbody//td[contains(text(), 'Donald')]/following-sibling::td[2]/a")
   public WebElement viewDetails;

}