package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterItemsPage;
import pages.CraterLandingPage;
import utils.BrowserUtils;
import utils.Driver;

public class LandingPageComponents {
	CraterLandingPage landingPage = new CraterLandingPage();
	CraterDashboardPage dashboardPage = new CraterDashboardPage();
	CraterItemsPage itemsPage = new CraterItemsPage();
	BrowserUtils utils = new BrowserUtils();
	
	@Given("User enters valid credentials")
	public void user_enters_valid_credentials() throws InterruptedException {
		Driver.getDriver().get("http://invoice.primetech-apps.com/login");
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		utils.sendKeysWithActionsClass(landingPage.useremail, "ankzzone@gmail.com");
		utils.sendKeysWithActionsClass(landingPage.password, "Test1234");
		
		
	}
	@Given("clicks on login")
	public void clicks_on_login() {
		landingPage.loginButton.click();
	}
	@When("User clicks Items Menu link")
	public void user_clicks_items_menu_link() {
	   dashboardPage.Items.click();
	}
	@Then("User should be on Items page")
	public void user_should_be__on_items_page() {
	   Assert.assertTrue(itemsPage.itemsHeaderText.isDisplayed());
	}
	@Then("User should see other Items page elements")
	public void user_should_see_other_items_page_elements() {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
		wait.until(ExpectedConditions.visibilityOf(itemsPage.filterItemButton));
		Assert.assertTrue(itemsPage.filterItemButton.isDisplayed());
		Assert.assertTrue(itemsPage.addItemButton.isDisplayed());
		Driver.getDriver().close();
	}
	

}
