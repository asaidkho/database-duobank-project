package com.automationpractice.stepDefs;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.automationpractice.pages.LoginPage;
import com.automationpractice.pages.SignUpPage;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.DatabaseUtils;
import com.automationpractice.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStepDefs {
	
	private String fname;
	private String lname;
	private String email;
	private String password;
	
	@Given("I am on the login page2")
	public void iAmOnTheLoginPage() {
	    Driver.getDriver().get(ConfigReader.getProperty("url"));
	   
	}

	@Given("I click on the sign up link")
	public void iClickOnTheSignUpLink() {
	    LoginPage lp = new LoginPage();
	    lp.signupLink.click();
	}

	@When("I fill out the field with the following data and click on submit")
	public void iFillOutTheFieldWithTheFollowingDataAndClickOnSubmit(List<Map<String, String>> newUser) {
		
		
	    
		fname = newUser.get(0).get("fname");
		lname = newUser.get(0).get("lname");
		email = newUser.get(0).get("email");
		password = newUser.get(0).get("password");
		
		DatabaseUtils.updateQuery("DELETE FROM tbl_user WHERE email='" + email + "'");
		//Driver.getDriver().navigate().refresh();
		
	    SignUpPage sp = new SignUpPage();
	    sp.fnameField.sendKeys(fname);
	    sp.lnameField.sendKeys(lname);
	    sp.emailField.sendKeys(email);
	    sp.passwordField.sendKeys(password);
	    
	    sp.signUpButton.click();
	}

	@Then("I get to the account page")
	public void iGetToTheAccountPage() {
	    
	}

	@Then("Database is supposed to have the data provided on sign up page")
	public void databaseIsSupposedToHaveTheDataProvidedOnSignUpPage() {
	    
		List<Map<String, Object>> result = DatabaseUtils.getQueryResultMap("SELECT COUNT(*) as c FROM tbl_user "
				+ "WHERE first_name='" + fname + 
				"' AND last_name='" + lname + "' AND email='" + email + "'");
		
		
		
		Assert.assertTrue(Integer.parseInt(result.get(0).get("c").toString()) == 1);
		
	}

}
