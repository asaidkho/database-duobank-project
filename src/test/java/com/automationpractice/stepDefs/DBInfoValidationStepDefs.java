package com.automationpractice.stepDefs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

import com.automationpractice.utilities.DatabaseUtils;

import io.cucumber.java.en.Then;

public class DBInfoValidationStepDefs {
	
	List<List<Object>> isNotMatch;
	
	@Then("Borrower phone number is nine digit in xxx-xx-xxxx format")
	public void borrower_phone_number_is_nine_digit_in_xxx_xx_xxxx_format() {
		List<List<Object>> actual = DatabaseUtils.getQueryResultList("select b_cell from tbl_mortagage;");
		for (int i=0; i<actual.size(); i++) {
			Assert.assertTrue(actual.get(i).toString().matches("^\\d{3}-\\d{2}-\\d{4}$"));
			//if (actual.get(i).toString().matches("(\\d{3})-\\d{2}-\\d{4}") == false) {
			//	isNotMatch = DatabaseUtils.getQueryResultList("select id from tbl_mortagage where b_cell="+actual.get(i)+";");
			//}
		}

	}

	@Then("SSN is filled out and follow xxx-xx-xxxx format")
	public void ssn_is_filled_out_and_follow_xxx_xx_xxxx_format() {
		List<List<Object>> actual = DatabaseUtils.getQueryResultList("select b_ssn from tbl_mortagage;");
		for (int i=0; i<actual.size(); i++) {
			Assert.assertTrue(actual.get(i).toString().matches("^\\d{3}-\\d{2}-\\d{4}$"));
//			if (actual.get(i).toString().matches("(\\d{3})-\\d{2}-\\d{4}") == false) {
//				isNotMatch = DatabaseUtils.getQueryResultList("select id from tbl_mortagage where b_ssn='';");
//			}
		} 
	}

}
