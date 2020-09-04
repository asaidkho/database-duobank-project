package com.automationpractice.stepDefs;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Kamil_APIStepDefs {
	
	String token;
	
	@Test
	public void api_test() {
		
		RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("first_name", "Elmer");
		map.put("last_name", "Fudd");
		
		
		map.put("email", "efudd" + (int) (Math.random()*1000) + "@gmail.com");
		map.put("password", "fudd123");
		
		
		
		given().
			body(map).
		when().
			post("/api/register.php").
		then().log().all()
			.statusCode(200).extract().response();
			
		
	}
	
	@Test
	public void login() {
		
		RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
		
		Map<String, Object> user = new HashMap<>();
		
		user.put("email", "dtrump@gmail.com");
		user.put("password", "trump123");
		
		
		JsonPath jp = given().
			body(user)
		.when()
			.post("/api/login.php")
		.then().log().all()
			.assertThat()
			.statusCode(200).extract().response().jsonPath();
		
		token = jp.getString("token");
				
		System.out.println(token);
	}
	
	@Test
	public void getMortgages() {
		RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
		
		login();
		JsonPath jp = given()
			.header("Authorization", token)
		.when()
			.get("/api/getmortagage.php")
		.then().log().all()
			.assertThat().statusCode(200)
			.extract().response().jsonPath();
		
		
	}
	
	@Test
	public void getMortgageDetails() {
		
		RestAssured.baseURI = "http://duobank-env.eba-bgkwzq3h.us-east-2.elasticbeanstalk.com";
		
		login();
		
		Map<String, Object> mortgage = new HashMap<>();
		mortgage.put("id", 9);
		
		JsonPath jp = given()
			.header("Authorization", token)
			.body(mortgage)
		.when()
			.post("/api/mortagagedetails.php")
		.then().log().all()
			.assertThat()
			.statusCode(200).extract().response().jsonPath();			
		
		
		
	}

}
