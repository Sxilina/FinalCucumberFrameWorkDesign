package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterDashboardPage;
import pages.CraterItemsPage;
import utils.Driver;

public class AdditemPageComponents {
	CraterDashboardPage dashboardPage = new CraterDashboardPage();
	CraterItemsPage itemsPage = new CraterItemsPage();
	@When("User clicks Add Item button")
	public void user_clicks_add_item_button() {
	    itemsPage.addItemButton.click();
	    Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@Then("User should see Add Item page components")
	public void user_should_see_add_item_page_components() {
	  
		Assert.assertTrue(itemsPage.addItemNameField.isEnabled());
	   Assert.assertTrue(itemsPage.addItemPriceField.isEnabled());
	   Assert.assertTrue(itemsPage.addItemUnitField.isEnabled());
	   Assert.assertTrue(itemsPage.addItemDescription.isEnabled());
	   Driver.getDriver().close();
	}

}
