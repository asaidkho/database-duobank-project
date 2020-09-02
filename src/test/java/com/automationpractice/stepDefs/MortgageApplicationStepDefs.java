package com.automationpractice.stepDefs;


import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.automationpractice.pages.BasePage;
import com.automationpractice.pages.MortgageApplicationPage;
import com.automationpractice.pojos.MortgageApplication;
import com.automationpractice.utilities.BrowserUtilities;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.DatabaseUtils;
import com.automationpractice.utilities.Driver;
import com.automationpractice.utilities.ExcelUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class MortgageApplicationStepDefs {
	
	//int rowNum = 1;
	
	@Given("I am on the homepage")
	public void iAmOnTheHomepage() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
	}
	
	@Given("I login")
	public void i_login() {
		BasePage bp = new BasePage();
		bp.loginEmail.sendKeys(ConfigReader.getProperty("username"));
		bp.loginPassword.sendKeys(ConfigReader.getProperty("password"));
		bp.loginButton.click();
	}

	@Given("I click  on Mortgage Application on the Dashboard")
	public void i_click_on_mortgage_application_on_the_dashboard() {
		MortgageApplicationPage map = new MortgageApplicationPage();
		map.mortgageApplication.click();
		BrowserUtilities.waitFor(2);		
	}

	@When("I fill out the Mortgage Application step by step, and agreed with eDisclosure Agreement")
	public void i_fill_out_the_mortgage_application_step_by_step_and_agreed_with_e_disclosure_agreement(MortgageApplication info) {
		MortgageApplicationPage map = new MortgageApplicationPage();
		Actions a = new Actions(Driver.getDriver());
		ExcelUtils eu = new ExcelUtils("src\\test\\resources\\testData\\Mortgage Application Info.xlsx", "Sheet1");
		
		//info.setRealtor_info(eu.getCellData(1, 0));
		
		//PreApproval Details
		map.realtorInfoField.sendKeys(eu.getCellData(info.getRow(), 0));
		map.estimatedPurchasePrice.sendKeys(eu.getCellData(info.getRow(), 1));
		map.downPaymentAmount.sendKeys(eu.getCellData(info.getRow(), 2));
		map.downPaymentPercentage.sendKeys(eu.getCellData(info.getRow(), 3));
		map.nextButton.click();
		//Personal Information
		map.borrowerFirstName.sendKeys(eu.getCellData(info.getRow(), 4));
		map.borrowerLastName.sendKeys(eu.getCellData(info.getRow(), 5));
		map.borrowerEmail.sendKeys(eu.getCellData(info.getRow(), 6));
		map.borrowerDOB.sendKeys(eu.getCellData(info.getRow(), 7));   // if wouldn't work use Actions class
		map.borrowerSSN.sendKeys(eu.getCellData(info.getRow(), 8));
		a.moveToElement(map.borrowerSelectMaritalStatusContainer).click().sendKeys(eu.getCellData(info.getRow(), 9)).sendKeys(Keys.ENTER).build().perform();
		map.borrowerCellPhone.sendKeys(eu.getCellData(info.getRow(), 10));
		map.nextButton.click();
		//Expenses
		map.monthlyRentalPayment.sendKeys(eu.getCellData(info.getRow(), 11));
		map.nextButton.click();
		//Employment and Income
		map.employerName.sendKeys(eu.getCellData(info.getRow(), 12));
		map.grossMonthlyIncome.sendKeys(eu.getCellData(info.getRow(), 13));
		map.nextButton.click();
		//eConsent
		map.eConsentdeclarerFirstName.sendKeys(eu.getCellData(info.getRow(), 14));
		map.eConsentdeclarerLastName.sendKeys(eu.getCellData(info.getRow(), 15));
		map.eConsentdeclarerEmail.sendKeys(eu.getCellData(info.getRow(), 16));
		map.agree.click();
		map.nextButton.click();
	}

	@When("Click Save to submit the application")
	public void click_save_to_submit_the_application() {
		MortgageApplicationPage map = new MortgageApplicationPage();
		map.saveButton.click();	
	}

	@Then("The data user entered into the Mortgage Application should be reflect accordingly in database with the correct information about user's Mortgage Application entry")
	public void the_data_user_entered_into_the_mortgage_application_should_be_reflect_accordingly_in_database_with_the_correct_information_about_user_s_mortgage_application_entry(MortgageApplication info) {
		//select * from tbl_mortagage ORDER BY id DESC LIMIT 1; - to get last record in DB
		List<Map<String, Object>> actual = DatabaseUtils.getQueryResultMap("select realtor_info, est_purchase_price, down_payment, down_payment_percent,\r\n" + 
				"b_firstName, b_lastName, b_email, b_dob, b_ssn, b_marital, b_cell, monthly_rental_payment, employer_name, gross_monthly_income, eConsent_declarer_FirstName,\r\n" + 
				"eConsent_declarer_LastName, eConsent_declarer_Email from tbl_mortagage ORDER BY id DESC LIMIT 1;");
		ExcelUtils eu = new ExcelUtils("src\\test\\resources\\testData\\Mortgage Application Info.xlsx", "Sheet1");
		for (int i=0; i<=16; i++) {
			Assert.assertEquals(eu.getCellData(info.getRow(), i), actual.get(i));
		}
		
		//Assert.assertEquals(expected=excellCell, actual=DBvalue);
	}

}
