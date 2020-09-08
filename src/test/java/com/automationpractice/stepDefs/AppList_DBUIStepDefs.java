package com.automationpractice.stepDefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.automationpractice.pages.AppListPage;
import com.automationpractice.pages.BasePage;
import com.automationpractice.pages.LoginPage;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.DatabaseUtils;
import com.automationpractice.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AppList_DBUIStepDefs {
	
	@Given("I login to the website")
	public void iLoginToTheWebsite() {
		Driver.getDriver().get(ConfigReader.getProperty("url"));
	    new LoginPage().login();		
	}

	@Given("I click on the Application List link")
	public void iClickOnTheApplicationListLink() {
	   new BasePage().appListLink.click();
	}

	@Then("Borrower Name and Loan Amount in the list must match database entries")
	public void borrowerNameAndLoanAmountInTheListMustMatchDatabaseEntries() {
		AppListPage alp = new AppListPage();
		for(int i=0; i<alp.borrowerNames.size(); i++) {
			
			String loanAmount = "''";
			if (Integer.parseInt(alp.loanAmounts.get(i).getText())>0) 
				loanAmount = alp.loanAmounts.get(i).getText();
			
			String query = "SELECT COUNT(*) AS c FROM tbl_mortagage WHERE "
					+ "replace(concat(b_firstName, ' ',b_middleName, ' ',b_lastName), '  ', ' ')='" 
					+ alp.borrowerNames.get(i).getText() + "' AND total_loan_amount=" + loanAmount;
			
			System.out.println(query);
			
			List<Map<String, Object>> result = DatabaseUtils.getQueryResultMap(query);
			
			Assert.assertEquals(1, Integer.parseInt(result.get(0).get("c").toString()));
			
		}
	}

}
