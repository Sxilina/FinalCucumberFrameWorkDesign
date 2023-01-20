package step_defination;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterLoginPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class LoginPageSteps {
	
	CraterLoginPage craterLogin = new CraterLoginPage();
	BrowserUtils utils = new BrowserUtils();
	
	

	@Given("user is on the LoginPage")
	public void user_is_on_the_login_page() {
	//Driver.getDriver().manage().window().maximize();
	
//		js.executeScript("window.resizeTo(600,600);");
		
		  Driver.getDriver().get(TestDataReader.getProperty("craterLoginUrl"));
		  
		  
		//Check Login page UI components  
	}
	@Then("the system should display page title")
	public void the_system_should_display_page_title() {
		Assert.assertTrue(craterLogin.loginPageTitle.isDisplayed());
	}
	@Then("Text box with label email textbox")
	public void text_box_with_label_email_textbox() {
	    Assert.assertEquals("Email *", craterLogin.emailText.getText());
	}
	@Then("Text box with label password textbox")
	public void text_box_with_label_password_textbox() {
		Assert.assertEquals("Password *", craterLogin.passwordText.getText());
	}
	
	@Then("CopyRight text on the bottom left")
	public void CopyRight_text_on_the_bottom_left() {
		
		
		//utils.waitUntilElementVisible(craterLogin.CopyRightText);
		//Assert.assertTrue(craterLogin.CopyRightText.isDisplayed());
	}
	@Then("Heading1 to the right")
	public void heading1_to_the_right() {
		Assert.assertEquals(TestDataReader.getProperty("Heading1"), craterLogin.Heading1.getText());
	}
	@Then("Heading2 underneath Heading1")
	public void heading2_underneath_heading1() {
		//Assert.assertTrue(craterLogin.Heading2.isDisplayed());
	}
	
	
	
	//Test Valid Login credentials
	
	@When("user enters valid {string} and {string}")
	public void user_enters_valid_and(String useremail, String password) {
		
		 utils.sendKeysWithActionsClass(craterLogin.useremail, "abudu.oy@gmail.com");
		   utils.sendKeysWithActionsClass(craterLogin.password, "Password1234");
	}
	@Given("clicks on the login button")
	public void clicks_on_the_login_button() {
		 craterLogin.loginButton.click();;
	}
	@Then("user should be on the dashboard page")
	public void user_should_be_on_the_dashboard_page() {
		utils.waitUntilElementVisible(craterLogin.amountDueText);
	    Assert.assertTrue(craterLogin.amountDueText.isDisplayed());
	}
	@Then("user quits the browser")
	public void user_quits_the_browser() {
		  Driver.quitDriver();
	}
	
	
	//Test Invalid Login credentials
	@When("user enters invalid {string} and {string}")
	public void user_enters_invalid_and(String invalidUseremail, String invalidPassword) {
		 utils.sendKeysWithActionsClass(craterLogin.useremail, invalidUseremail);
		 utils.sendKeysWithActionsClass(craterLogin.password, invalidPassword);
	}
	
	@Then("invalid credential error messages appear")
	public void invalid_credential_error_messages_appear() {
		utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
	    Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
	    
	}
	
	
	//Test Empty Login
	boolean useremailEmpty;
	boolean passwordEnpty;
	@When("user leaves useremail {string} and password {string} empty")
	public void user_leaves_useremail_and_password_empty(String useremail, String password) {
		
		useremailEmpty = useremail.isBlank();
		passwordEnpty = password.isBlank();
		
		utils.sendKeysWithActionsClass(craterLogin.useremail, useremail);
		 utils.sendKeysWithActionsClass(craterLogin.password, password);
	
	}
	@Then("Field Required error messages appear")
	public void field_required_error_messages_appear() {
		if (useremailEmpty || passwordEnpty) {
	    	utils.waitUntilElementVisible(craterLogin.fieldRequired);
		    Assert.assertTrue(craterLogin.fieldRequired.isDisplayed());
		} else {
			utils.waitUntilElementVisible(craterLogin.invalidUserErrorMessage);
			Assert.assertTrue(craterLogin.invalidUserErrorMessage.isDisplayed());
		}
		
	}
	
	//Test Forgot password link
	@Given("clicks on the Forgot Password ? Link button")
	public void clicks_on_the_forgot_password_link_button() {
		utils.waitUntilElementVisible(craterLogin.forgotPasswordLink);
		craterLogin.forgotPasswordLink.click();;
	}
	@Then("Enter email text, Send Reset Link button and Back to Login Link is displayed")
	public void enter_email_text_send_reset_link_button_and_back_to_login_link_is_displayed() {
		utils.waitUntilElementVisible(craterLogin.enterEmailText);
		Assert.assertTrue(craterLogin.enterEmailText.isDisplayed());
		
		utils.waitUntilElementVisible(craterLogin.SendResetLink);
		Assert.assertTrue(craterLogin.SendResetLink.isDisplayed());
		
		utils.waitUntilElementVisible(craterLogin.BacktoLogin);
		Assert.assertTrue(craterLogin.BacktoLogin.isDisplayed());
		
		
	}
	
	//Test Reset password 
	@When("user leaves the email field blank")
	public void user_leaves_the_email_field_blank() {
		utils.waitUntilElementVisible(craterLogin.enterEmailField);
		utils.sendKeysWithActionsClass(craterLogin.enterEmailField, "");
	}
	@When("clicks on the Send Reset Link button")
	public void clicks_on_the_send_reset_link_button()  {
		utils.waitUntilElementVisible(craterLogin.enterEmailField);
	    craterLogin.SendResetLink.click();
	}
	@Then("user should see error message Field is required")
	public void user_should_see_error_message_field_is_required() {
	    utils.waitUntilElementVisible(craterLogin.fieldRequired);
	    Assert.assertTrue(craterLogin.fieldRequired.isDisplayed());
	}
	@When("user enters invalid email {string}")
	public void user_enters_invalid_email(String email)  {
		utils.sendKeysWithActionsClass(craterLogin.useremail, "primetech");
		
	}
	@Then("user should see error message Incorrect Email")
	public void user_should_see_error_message_incorrect_email() {
		 utils.waitUntilElementVisible(craterLogin.IncorrectEmailMessage);
		    Assert.assertEquals(TestDataReader.getProperty("IncorrectEmailMessage"),craterLogin.IncorrectEmailMessage.getText());
	}
	@When("user enters valid email {string}")
	public void user_enters_valid_email(String email) throws InterruptedException {
		
		utils.waitUntilElementVisible(craterLogin.enterEmailField);
		utils.sendKeysWithActionsClass(craterLogin.enterEmailField, "abudu.oy@gmail.com");
	}
	@Then("user should see success message")
	public void user_should_see_success_message() {
		utils.waitUntilElementVisible(craterLogin.SuccessMessage);
	    Assert.assertTrue(craterLogin.SuccessMessage.isDisplayed());
	}

}
