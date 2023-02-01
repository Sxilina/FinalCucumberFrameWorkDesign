package APILoginLogout;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class APILoginLogout {
	
	

	/*
	 * 	Login
		Given I am an authorized user of the "LOGIN" REST API webservice,
        When I send a request to the "LOGIN" with the ‘POST’ HTTP method,
        If the request is successful then HTTP Status Code 200 code should be returned.
        The response body should provide the following elements: token+type
	 */
	@Test
	public static void loginsetUp() {
		RestAssured.baseURI="http://invoice.primetech-apps.com/api/v1/auth/login";
		
		String requestBody ="{\n"
				+ "    \"username\": \"farisnazar45@gmail.com\",\n"
				+ "    \"password\": \"Test1234\",\n"
				+ "    \"device_name\":\"mobile_app\"\n"
				+ "}";
		
		Response myResponse= RestAssured.given().accept(ContentType.JSON)
				.contentType("application/json").body(requestBody).when()
				.post();
		
		myResponse.then().statusCode(200).and().contentType("application/json");
		myResponse.prettyPrint();
	}
	
	
	//Logout
	/*
	 * Given I am an authorized user of the "LOGOUT" REST API webservice,

		When I send a request to the "Get User" with the ‘POST’ HTTP method,
		
		Then the "LOGOUT"  REST API should: If the request is successful then HTTP Status Code 200 code should be returned.
		
		I should be able to view that the user is sucessfully logged out.
	 */
	@Test
	public static void logoutsetUp() {
		RestAssured.baseURI="http://invoice.primetech-apps.com/api/v1/auth/logout";
		
	    String token = "225|arEsvgDTEdKzmkTWjtlXqAIiarkPlMy8ghw8yOqA";
		
		Response myResponse= RestAssured.given().accept(ContentType.JSON)
				.contentType("application/json").headers("Authorization","Bearer" +token)
				.when()
				.post();
		
		myResponse.then().statusCode(200).and().contentType("application/json");
		myResponse.prettyPrint();
	}







}


