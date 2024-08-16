package com.stepdefinition;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeletePlace")
	public void beforeTestScenario() throws IOException {
		StepDefinition m=new StepDefinition();
		if(m.PLACEID==null) {
		m.add_place_payload_with("Lokesh","French","Africa");
		m.user_call_with_http_request("AddPlaceApi","POST");
		m.verify_place_id_created_maps_to_using("Lokesh","GetPlaceApi");}
	}

}
