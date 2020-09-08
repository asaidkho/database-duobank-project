package com.automationpractice.stepDefs;

import java.util.Map;

import com.automationpractice.pojos.User;

import io.cucumber.java.DataTableType;

public class CustomTypeTransformer {



@DataTableType
public User myUser(Map<String, String> row) {
	
	String email = row.get("email");
	String password = row.get("password");
	
		return new User(email, password);
	
}
}
