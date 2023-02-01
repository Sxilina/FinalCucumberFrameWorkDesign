package step_defination;

import org.junit.Assert;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterLogin_LogoutPage;
import utils.BrowserUtils;
import utils.Driver;
import utils.TestDataReader;

public class LoginLogout {
	
	CraterLogin_LogoutPage craterLogin_Logout=new CraterLogin_LogoutPage();
	BrowserUtils utils=new BrowserUtils();
	
	//1.verifying the UI component 
	
	@Given("user is on login page")
	public void user_is_on_login_page() {
	Driver.getDriver().manage().window().maximize();
	Driver.getDriver().get(TestDataReader.getProperty("CraterLoginURL"));
	}
	@Then ("Login page shows page title")
	public void Login_page_shows_page_title() {
		Assert.assertTrue(craterLogin_Logout.pageTitle.isDisplayed());
	}	
	@Then ("Text1 box with the Label Email")	
	public void Text1_box_with_the_Label_Email() {
		Assert.assertEquals("Email *", craterLogin_Logout.username.getText());
	}
   @Then ("Text2 box with the Label Password")
   public void Text2_box_with_the_Label_Password() {
	   Assert.assertEquals("Password *",craterLogin_Logout.password.getText());
   }
   
   @Then ("Copy right text shows on the page")
   public void Copy_right_text_shows_on_the_page() {
   Assert.assertTrue(craterLogin_Logout.CopyRightText.isDisplayed());  
   }
   
   @Then ("Heading1 located to the right")
   public void And_Login_button_shows_under_textbox() {
   Assert.assertTrue(craterLogin_Logout.Header1.isDisplayed());  
    }
   
   @Then ("Heading2 located underneath of heading1")
   public void Heading2_located_underneath_of_heading1() {
   Assert.assertTrue(craterLogin_Logout.Header2.isDisplayed());  
    }
   
   //2.valid user account
   @When ("user enter valid username {String} and valid password {String}")
   public void user_enter_valid(String email, String password){
	   utils.sendKeysWithActionsClass(craterLogin_Logout.username, "sharon6170@gmail.com");
	   utils.sendKeysWithActionsClass(craterLogin_Logout.password, "Test1234");
   }
   
   @Then ("user clicks Login button")
   public void user_clicks_Login_button() {
	   craterLogin_Logout.LogoutButton.click();
   }
   @Then ("user will be on the dashboard")
   public void user_will_be_on_the_dashboard() {
	   utils.waitUntilElementVisible(craterLogin_Logout.DashBoardPage);
		Assert.assertTrue(craterLogin_Logout.DashBoardPage.isDisplayed());
   }
   @Then("user quit the browser")
   public void user_quit_the_browser() {
	   Driver.quitDriver();
   }
   
   
	//invalid user account
   @When ("user enter invalide {String} and password {String}")
   public void user_enters_invalide(String email, String password) {
	   utils.sendKeysWithActionsClass(craterLogin_Logout.username, "didngietiv@yahoo.com");
	   utils.sendKeysWithActionsClass(craterLogin_Logout.password, "password:Hello4556");
   }   
   @Then("user clicks login button")	   
   public void user_clicks_login_button() {
	   craterLogin_Logout.LogoutButton.click();
   }
	@Then("user will see red message error ")
	public void user_will_see_red_message_error() {
		utils.waitUntilElementVisible(craterLogin_Logout.ErrorMessage);
		Assert.assertTrue(craterLogin_Logout.ErrorMessage.isDisplayed());
	}
   
	//empty input login button
	boolean useremailEmpty;
	boolean passwordEnpty;
	@When("user leaves empty username{}and password {}")
	public void user_leaves_empty_username_and_password(String useremail, String password) {
		
		useremailEmpty = username.isBlank();                                                                        me.isBlank();
		passwordEnpty = password.isBlank();

		utils.sendKeysWithActionsClass(craterLogin_Logout.username, useremail);
		 utils.sendKeysWithActionsClass(craterLogin_Logout.password, password);
	}
	
	
	
	
	
	
	
	
	
	
	
}
