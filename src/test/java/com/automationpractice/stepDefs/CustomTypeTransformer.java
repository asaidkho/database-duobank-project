package com.automationpractice.stepDefs;

import java.util.List;

import com.automationpractice.pojos.MortgageApplication;

import io.cucumber.java.DataTableType;

public class CustomTypeTransformer {

	@DataTableType
	public MortgageApplication row(List<String> row) {	
		return new MortgageApplication(row.get(0));
	}
	
	
}
