package step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class apitesting {
 @When("I send a request to the Creator customer with the ‘POST’ HTTP method,")
	public void i_send_a_request_to_the_creator_customer_with_the_post_http_method() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	    
//	    Response myResponse = RestAssured.given().accept(ContentType.JSON).contentType("application/json")
//				.body(catRequestBody).when().post("/pet");
//		
//		myResponse.then().statusCode(200).and().contentType("application/json");
//		myResponse.prettyPrint();
//
//	    
	    
	}
	@Then("I should get {int} status code")
	public void i_should_get_status_code(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("The customer should be created in the application database.")
	public void the_customer_should_be_created_in_the_application_database() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}
