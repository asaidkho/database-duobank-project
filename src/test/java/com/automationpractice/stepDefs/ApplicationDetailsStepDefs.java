package com.automationpractice.stepDefs;


import java.sql.Driver;

import com.automationpractice.pages.ApplicationPage;
import com.automationpractice.pages.BasePage;
import com.automationpractice.pages.DashboardPage;
import com.automationpractice.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationDetailsStepDefs {

	
	
	@Given("I am on the mainpage")
	public void i_am_on_the_mainpage() {
		
		Driver.getDriver().get(ConfigReader.getProperty("url"));	    
	
	}

	@When("I log in to account")
	public void i_log_in_to_account() {
		
		BasePage bp = new BasePage();
		bp.loginEmail.sendKeys("dtrump@gmail.com");
		bp.loginPassword.sendKeys("trump123");
		bp.loginButton.click();
	   
	}

	@When("I land on a Dashboard I click on Application list")
	public void i_land_on_a_dashboard_i_click_on_application_list() {
	   
		DashboardPage dp = new DashboardPage();
		dp.applicationList.click();
		
	}

	@When("I click View Details to open application")
	public void i_click_view_details_to_open_application() {
		DashboardPage dp = new DashboardPage();
		dp.viewDetails.click();
	}

	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
