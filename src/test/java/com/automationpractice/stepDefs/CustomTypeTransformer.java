package com.automationpractice.stepDefs;

import java.util.Map;

import com.automationpractice.pojos.NewUser;
import com.automationpractice.pojos.User;

import io.cucumber.java.DataTableType;

public class CustomTypeTransformer {



@DataTableType
public User myUser(Map<String, String> row) {
	
	String email = row.get("email");
	String password = row.get("password");
	
		return new User(email, password);
	
}

@DataTableType
public NewUser newUser(Map<String, String> row2) {
	
	String first_name = row2.get("first_name");
	String last_name = row2.get("last_name");
	String email = row2.get("email");
	String password = row2.get("password");
	
		return new NewUser(first_name,last_name,email, password);
	
}
}
