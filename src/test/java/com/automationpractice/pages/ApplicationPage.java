package com.automationpractice.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApplicationPage extends BasePage {

	@FindBy(xpath="//*[@id=\"basic-datatable\"]//table[3]/tbody/tr/td[1]")
    public WebElement own;

	@FindBy(xpath = "//table[2]/tbody/tr[2]/td[1]")
	public WebElement email1;

	@FindBy(xpath= "//table[2]/tbody/tr[2]/td[2]")
	public WebElement DateOfBirth;

	@FindBy(xpath = "//table[2]/tbody/tr[3]/td[2]")
	public WebElement maritalStatus;

	@FindBy(xpath = "//table[2]/tbody/tr[3]/td[1]")
	public WebElement SSN;

	@FindBy(xpath = "//table[2]/tbody/tr[4]/td[1]")
	public WebElement cellPhone;

	@FindBy(xpath = "//table[1]/tbody/tr[2]/td[1]")
	public WebElement purchasePrice;

	@FindBy(xpath = "//table[1]/tbody/tr[3]/td[1]")
	public WebElement sourceOfDownPayment;

	@FindBy(xpath = "//table[1]/tbody/tr[2]/td[2]")
	public WebElement downPayment;

	@FindBy(xpath = "//table[1]/tbody/tr[2]/td[3]")
	public WebElement percentage;
	
	@FindBy(xpath = "//table[1]/tbody/tr[2]/td[4]")
	public WebElement loanAmount;
	
	@FindBy(xpath = "//table[1]/tbody/tr[1]/td[4]")
	public WebElement loanOfficer;
	
	@FindBy(xpath = "//table[1]/tbody/tr[1]/td[3]")
	public WebElement purposeLoan;
	
	@FindBy(xpath = "//table[1]/tbody/tr[1]/td[2]")
	public WebElement realtorInfo;
	
	@FindBy(xpath = "//table[1]/tbody/tr[1]/td[1]")
	public WebElement realtor;
	
	@FindBy(xpath = "//table[1]/tbody/tr[3]/td[3]")
	public WebElement coBorrower;
	
	@FindBy(xpath = "//table[4]/tbody/tr[1]/td[1]")
	public WebElement employerName;
	
	@FindBy(xpath = "//table[4]/tbody/tr[1]/td[2]")
	public WebElement position;
	
	@FindBy(xpath = "//table[4]/tbody/tr[2]/td[2]")
	public WebElement state;
	
	@FindBy(xpath = "//table[4]/tbody/tr[2]/td[1]")
	public WebElement city;
	
	@FindBy(xpath = "//table[4]/tbody/tr[1]/td[2]")
	public WebElement startDate;
	
	@FindBy(xpath = "//table[5]/tbody/tr[1]/td[1]")
	public WebElement grosslyMonthIncome;
	
	@FindBy(xpath = "//table[5]/tbody/tr[2]/td[3]")
	public WebElement totalMonthlyIncome;
	
	@FindBy(xpath = "//table[7]/tbody/tr[1]/td[1]")
	public WebElement declearer;
	
	@FindBy(xpath = "//table[7]/tbody/tr[1]/td[2]")
	public WebElement firstName;
	
	@FindBy(xpath = "//table[7]/tbody/tr[1]/td[3]")
	public WebElement lastName;
	
	@FindBy(xpath = "//table[7]/tbody/tr[2]/td[1]")
	public WebElement email2;
	
}
