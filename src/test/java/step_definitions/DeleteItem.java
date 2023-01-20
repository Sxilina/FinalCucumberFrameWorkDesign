package step_definitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterItemsPage;
import utils.Driver;

public class DeleteItem {
	CraterItemsPage itemsPage = new CraterItemsPage();
	String firstItemBeforeDelete = itemsPage.firstNameItemsTable.getText();
	@When("User should be on before delete Items page")
	public void user_should_be_on_before_delete_items_page() {
		Assert.assertTrue(itemsPage.itemsHeaderText.isDisplayed());
		
	}
	
	@When("USer clicks on Delete button")
	public void u_ser_clicks_on_delete_button() throws InterruptedException {
	    itemsPage.deleteButton.click();
	    Thread.sleep(2000);
	}
	@Then("User is shown a modal message with Ok and cancel buttons")
	public void user_is_shown_a_modal_message_with_ok_and_cancel_buttons() throws InterruptedException {
	
	  Assert.assertTrue(itemsPage.modalMessage.isDisplayed());
	  Assert.assertTrue(itemsPage.modalOkButton.isEnabled());
	  Assert.assertTrue(itemsPage.modalCancelButton.isEnabled());
	}
	@When("User click on cancel button")
	public void user_click_on_cancel_button() {
		itemsPage.modalCancelButton.click();
	}
	@When("User clicks Ok button")
	public void user_clicks_ok_button() {
	    itemsPage.modalOkButton.click();
	}
	@Then("User should see Delete item message")
	public void user_should_see_delete_item_message() {
	    itemsPage.itemDeletedSuccessMessage.isDisplayed();
	}
	@Then("User should be on after delete Items page")
	public void user_should_be_on_after_delete_items_page() {
		Assert.assertTrue(itemsPage.itemsHeaderText.isDisplayed());
	}
	@Then("User should not see Deleted Item")
	public void user_should_not_see_deleted_item() {
		WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 5);
		  wait.until(ExpectedConditions.visibilityOf(itemsPage.firstNameItemsTable));
		  String firstItemAfterDelete = itemsPage.firstNameItemsTable.getText();
		  Assert.assertNotEquals(firstItemBeforeDelete, firstItemAfterDelete);
		  Driver.getDriver().close();
	}

}
