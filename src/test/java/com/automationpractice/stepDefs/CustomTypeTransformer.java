package com.automationpractice.stepDefs;

import java.util.List;

import com.automationpractice.pojos.MortgageApplication;
import java.util.Map;

import com.automationpractice.pojos.User;

import io.cucumber.java.DataTableType;

public class CustomTypeTransformer {

	@DataTableType
	public MortgageApplication row(List<String> row) {	
		return new MortgageApplication(row.get(0));
	}
	
	


@DataTableType
public User myUser(Map<String, String> row) {
	
	String email = row.get("email");
	String password = row.get("password");
	
		return new User(email, password);
	
}
}
