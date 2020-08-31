package com.automationpractice.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(

		tags = "@db",
		features = "src/test/resources/com/americanexpress/features",
		glue = "com/americanexpress/stepDefs",
		plugin = {
				"summary",
				"pretty",
				
				"html:target/builtInReport",
				"json:target/Cucumber.json" // needed for pretty report
		},
		monochrome = true
//		,dryRun = true
		,snippets = SnippetType.CAMELCASE
		,stepNotifications = true
		
		)


public class CukeRunner {
}
