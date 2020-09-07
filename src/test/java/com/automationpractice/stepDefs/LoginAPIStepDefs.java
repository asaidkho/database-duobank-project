package com.automationpractice.stepDefs;

import java.util.List;
import java.util.Map;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.* ;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class LoginAPIStepDefs {
	
	Response rs;
	
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
	}

	@When("I sent POST request for login with valid credentials")
	public void i_sent_post_request_for_login_with_valid_credentials(List<Map<String, Object>> credentials) {
		rs = given().
				body("{\"email\":" + credentials.get(0).get("email") + 
						",\"password\":" + credentials.get(0).get("password") + "}")
		.when()
			.post("/api/login.php");
	}

	@Then("Login is succesfull and user get an Authorization Token in the response for authentication purpose")
	public void login_is_succesfull_and_user_get_an_authorization_token_in_the_response_for_authentication_purpose() {
	   rs.then().log().all()
				.assertThat()
				.statusCode(200).extract().response().jsonPath();
	}

}
