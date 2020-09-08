package com.automationpractice.stepDefs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

import com.automationpractice.pages.ApplicationPage;
import com.automationpractice.pages.BasePage;
import com.automationpractice.pages.DashboardPage;
import com.automationpractice.pojos.User;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.DatabaseUtils;
import com.automationpractice.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ApplicationDetailsStepDefs {

	String email;
	String password;
	String firstName;
	String lastName;
	String SSN;
	String position;
	String state;
	String city;
	String realtor;
	String purposeLoan;
	String percentage;
	
    List<Map<String, Object>> queryResultMap;
	private List<List<Object>> queryResultList;

	
	@Given("I am on the mainpage")
	public void i_am_on_the_mainpage() {
			
		Driver.getDriver().get(ConfigReader.getProperty("url"));	   
	}
		
	@When("I enter the following  deatils and  I log in")
	public void iEnterTheFollowingDeatilsAndILogIn(User User) {
	    BasePage bp = new BasePage();
        email = User.getEmail();
		password = User.getPassword();
		
		bp.email.sendKeys(email);
		bp.password.sendKeys(password);
		
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
		
		dp.entries.click();
		dp.allEntries.click();
		dp.viewDetails.click();
	}

	@Then("I verify Application details are matching with Application details in the DB")
	public void iVerifyApplicationDetailsAreMatchingWithApplicationDetailsInTheDB() {
	   
  ApplicationPage ap = new ApplicationPage();
        
        String query = "SELECT * FROM tbl_mortagage WHERE b_email='"+ email +"'" ;
		
		System.out.println(query);
		
		DatabaseUtils.getQueryResultMap(query);
		
		List<Map<String, Object>> queryResultMap = DatabaseUtils.getQueryResultMap(query);
		
		Map<String, Object> map = queryResultMap.get(0);
		
		Assert.assertEquals(map.get("b_firstName"), ap.firstName.getText());
		Assert.assertEquals(map.get("b_lastName"), ap.lastName.getText());
		Assert.assertEquals(map.get("b_ssn"), ap.SSN.getText());
		Assert.assertEquals(map.get("realtor_info"), ap.realtorInfo.getText());
		Assert.assertEquals(map.get("purpose_loan"), ap.purposeLoan.getText());
		Assert.assertEquals((map.get("down_payment_percent")+" %"), ap.percentage.getText());
		Assert.assertEquals(map.get("city"), ("[\""+ ap.city.getText()+"\"]"));
		Assert.assertEquals(map.get("position"), ("[\""+ap.position.getText()+"\"]"));
		
		DatabaseUtils.updateQuery("delete from tbl_user where username='"+email +"'");

	}
	@Given("I retrive first name and last name from users table")
	public void iRetriveFirstNameAndLastNameFromUsersTable() {
	   
		 queryResultMap = DatabaseUtils.getQueryResultMap("SELECT COUNT(*) as c from tbl_user WHERE first_name='' or  first_name IS NULL or last_name IS NULL or last_name='';");
	}

	@Then("I verify first name and last name is not null")
	public void iVerifyFirstNameAndLastNameIsNotNull() {
	    
		int expectedCount = 0;
		for (Map<String, Object> map : queryResultMap) {
			
			   Assert.assertEquals(expectedCount,Integer.parseInt(map.get("c").toString()));
		}
	}
    @Given("I retrive purpose_loan  from database")
	public void iRetrivePurposeLoanFromDatabase() {
		
		queryResultList = DatabaseUtils.getQueryResultList(" SELECT  purpose_loan FROM tbl_mortagage;"); 
	
	}

	@Then("I verify purpose_loan content is correct")
	public void iVerifyPurposeLoanContentIsCorrect() {
		   String  expected =  "Purchase a Home";
		 
		    for (int i=0; i<queryResultList.size(); i++) {
		    	Assert.assertEquals(expected,queryResultList.get(i).get(0).toString());
			   }
		}
		}
	

