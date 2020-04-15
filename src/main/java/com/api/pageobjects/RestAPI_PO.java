package com.api.pageobjects;

import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI_PO {

	private static final Logger LOGGER = Logger.getLogger(RestAPI_PO.class.getName());

	public void testGetapi() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
		RequestSpecification request = RestAssured.given();
		Response response = request.get();
		int statuscode = response.getStatusCode();
		if (statuscode == BaseClass.SUCCESS_STATUSCODE) {
			LOGGER.info("Correct status code " + statuscode + " is coming in api response");
			JSONObject bodyObj = new JSONObject(response.getBody().asString());
			String message = bodyObj.get("status").toString();
			if (message.equals(BaseClass.SUCCESS_MESSAGE)) {
				LOGGER.info("Correct status message " + message + " is coming in api response");
				JSONArray array = bodyObj.getJSONArray("data");
				String employee_name = (String) array.getJSONObject(2).get("employee_name");
				LOGGER.info("Employee name for Index 3 is "+employee_name);// Here we can also apply the condition that name is coming correct or not
				 // Also you can use this code to find the name
				  /*Map<String, String> company = response.jsonPath().getMap("data[2]");
				  System.out.println(company.get("employee_name"));*/
				 

			} else {
				LOGGER.info("Incorrect status message " + message + " is coming in api response");
			}
		} else {
			LOGGER.info("Incorrect status code " + statuscode + " is coming in api response");
		}
	}

	public void testPostapi() {
		RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/create";
		RequestSpecification request = RestAssured.given();
		JSONObject request_Param= new JSONObject();
		request_Param.put("Sonia", "test");
		request_Param.put("salary", "60000");
		request_Param.put("age", "26");
		request.body(request_Param.toString());
		Response response = request.post();
		int statuscode = response.getStatusCode();
		if (statuscode == BaseClass.SUCCESS_STATUSCODE) {
			LOGGER.info("Correct status code " + statuscode + " is coming in api response"); }
		else {
			LOGGER.info("Incorrect status code " + statuscode + " is coming in api response"); }
		// Now we can extract the api response the same way we have done it in first API
		String status=response.jsonPath().get("status");
		LOGGER.info("status message  " +status+" is coming in api response"); 
	     String name=(String) response.jsonPath().getMap("data").get("name");
	     LOGGER.info("Name of the employee is "+name);
	}
	
}
