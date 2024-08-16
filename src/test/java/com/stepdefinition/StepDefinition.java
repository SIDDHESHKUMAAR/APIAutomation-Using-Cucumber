package com.stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.APIResources;
import resources.BaseClass;
import resources.TestDataBuild;

public class StepDefinition extends BaseClass {
	
	ResponseSpecification respspec;
	RequestSpecification Resp;
	Response res;
	static String PLACEID;
	JsonPath js;
	
	TestDataBuild data=new TestDataBuild();	
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_place_payload_with(String string, String string2, String string3) throws IOException {
		respspec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		 Resp=given().spec(RequestSpecifications()).body(data.addPlacePayload(string,string2,string3));	}
	

	@When("user Call {string} with {string} HTTP Request")
	public void user_call_with_http_request(String resource, String method) {
		//Constructor will be called with value of Resource which you pass
		APIResources resourceAPI=APIResources.valueOf(resource);
		System.out.println(resourceAPI.getResource());
		if(method.equalsIgnoreCase("POST")) {
		 res=Resp.when()
				.post(resourceAPI.getResource());}
		else if(method.equalsIgnoreCase("GET")) {
			res=Resp.when()
					.get(resourceAPI.getResource());
			
		}
	}

	@Then("the Api Call is success with Status Code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		assertEquals(res.getStatusCode(),200);
	    
	}

	@Then("{string} in Response body is  {string}")
	public void in_response_body_is(String Key, String Value) {
		String responsed=res.asString();
		 js=new JsonPath(responsed);
		
	    assertEquals(getJSONPath(res,Key),Value);
	}

	@Then("{string} in Resonse Body is {string}")
	public void in_resonse_body_is(String string, String string2) {
	   
	}
	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String Expectedname, String string2) throws IOException {
		PLACEID=getJSONPath(res,"place_id");
		Resp=given().spec(RequestSpecifications()).queryParam("place_id",PLACEID);
		user_call_with_http_request(string2,"GET");
		String name=getJSONPath(res,"name");
		assertEquals(name,Expectedname);
		
		
	}
	@Given("DeletePlace Payload")
	public void delete_place_payload() throws IOException {
		Resp= given().spec(RequestSpecifications()).body(data.DeleteAPi(PLACEID));	
	}

	

}
