package com.automationpractice.stepDefs;


	import io.cucumber.java.en.Given;
	import io.cucumber.java.en.Then;
	import io.cucumber.java.en.When;
	import io.restassured.RestAssured;
	import io.restassured.path.json.JsonPath;
	import io.restassured.response.Response;
	import static io.restassured.RestAssured.* ;
	import static io.restassured.matcher.RestAssuredMatchers.*;
	import static org.hamcrest.Matchers.*;

import java.util.List;
import java.util.Map;

import com.automationpractice.pojos.NewUser;

	public class APIStepDefs {

		Response rs;

		@Given("I am on the login page")
		public void i_am_on_the_login_page() {
			RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
		}

		@When("I sent POST request to create new user")
public void i_sent_post_request_to_create_new_user(List<Map<String,String>> row2) {
			
			rs = given().
					body("{\"first_name\":\"" + row2.get(0).get("first_name")+
							"\", \"last_name\":\"" + row2.get(0).get("last_name")
							+ "\",\"email\":\"" + row2.get(0).get("email") + 
							"\", \"password\":\"" + row2.get(0).get("password") + "\"}")
					
		.when()
				.post("/api/register.php");
		}

		@Then("New user is sucsessfully created")
		public void new_user_is_sucsessfully_created() {
		   rs.then().log().all()
					.assertThat()
					.statusCode(200).extract().response().jsonPath();
		}

	}


