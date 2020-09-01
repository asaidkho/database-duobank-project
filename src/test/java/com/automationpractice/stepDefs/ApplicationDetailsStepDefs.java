package com.automationpractice.stepDefs;



import java.util.List;
import java.util.Map;

import org.junit.Assert;

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
	String purposeOfLoan;
	
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
		dp.viewDetails.click();
	}

	@Then("I verify Application details are matching with Application details in the DB")
	public void iVerifyApplicationDetailsAreMatchingWithApplicationDetailsInTheDB() {
	   
  ApplicationPage ap =new ApplicationPage();
  
        //String b_email =email;
		String query = "SELECT *FROM tbl_mortagage WHERE b_email='"+email+"'" ;
		
		System.out.println(query);
		
		List<Map<String, Object>> queryResultMap = DatabaseUtils.getQueryResultMap(query);
		
		
		Map<String, Object> map = queryResultMap.get(0);
		
		Assert.assertEquals(map.get(firstName), ap.firstName.getText());
		Assert.assertEquals(map.get(lastName), ap.lastName.getText());
		Assert.assertEquals(map.get(SSN), ap.SSN.getText());
		Assert.assertEquals(map.get(position), ap.position.getText());
		Assert.assertEquals(map.get(state), ap.state.getText());
		Assert.assertEquals(map.get(city), ap.city.getText());
		Assert.assertEquals(map.get(realtor), ap.realtor.getText());
		Assert.assertEquals(map.get(purposeOfLoan), ap.purposeOfLoan.getText());
		
		DatabaseUtils.updateQuery("delete from users where username='"+email +"'");

	}
}
	

