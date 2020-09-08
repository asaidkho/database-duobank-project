package com.automationpractice.stepDefs;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

import com.automationpractice.utilities.DatabaseUtils;

import io.cucumber.java.en.Then;

public class Kamil_DBStepDefs {
	
	@Then("There should be nobody in the database tbl_mortagage who is under {int}")
	public void thereShouldBeNobodyInTheDatabaseTblMortagageWhoIsUnder(Integer int1) {
	   
		List<Map<String, Object>> results = DatabaseUtils.getQueryResultMap("SELECT b_dob FROM tbl_mortagage");
		
		
		for(Map<String, Object> row: results) {
			Assert.assertTrue(row.get("b_dob").toString().matches("(\\d{4})-\\d{2}-\\d{2}"));
			
			//if(!row.get("b_dob").toString().matches("(\\d{4})-\\d{2}-\\d{2}")) continue;
			
			int year = Integer.parseInt(row.get("b_dob").toString().substring(0,4));
			int month = Integer.parseInt(row.get("b_dob").toString().substring(5,7));
			int day = Integer.parseInt(row.get("b_dob").toString().substring(8,10));
			
			LocalDate dob = LocalDate.of(year, month, day);			
			dob = dob.plusYears(16);			
			Assert.assertTrue(dob.isBefore(LocalDate.now()));
			
		}
	}

	@Then("Email of the borrowers must have valid formats")
	public void emailOfTheBorrowersMustHaveValidFormats() {
		List<Map<String, Object>> results = DatabaseUtils.getQueryResultMap("SELECT b_email FROM tbl_mortagage");
		
		
		for(Map<String, Object> row: results) {
			
			System.out.println(row.get("b_email").toString());
			Assert.assertTrue(row.get("b_email").toString().matches("[\\w\\.]+@\\w+\\.\\w+"));			
			
		}
	  
	}

}
