package com.automationpractice.stepDefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.automationpractice.pages.BasePage;
import com.automationpractice.utilities.ConfigReader;
import com.automationpractice.utilities.DatabaseUtils;
import com.automationpractice.utilities.Driver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
	
	
	@Before ()
	public void setUp() {
		
		Driver.getDriver().manage().timeouts()
			.implicitlyWait(Long.parseLong(ConfigReader.getProperty("implicitWait")), TimeUnit.SECONDS);
		Driver.getDriver().manage().window().maximize();
		//BasePage bp = new BasePage();
		//bp.loginEmail.sendKeys(ConfigReader.getProperty("username"));
		//bp.loginPassword.sendKeys(ConfigReader.getProperty("password"));
		//bp.loginButton.click();
			
	}
	
	@Before ("@db")
	public void setUpDb(){
		DatabaseUtils.establishConnection();
	}
	
	
	@After ()
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");
		}
		
		Driver.quit();
	}
	
	@After ("@db")
	public void tearDownDB() {
		DatabaseUtils.close();
	}
}
