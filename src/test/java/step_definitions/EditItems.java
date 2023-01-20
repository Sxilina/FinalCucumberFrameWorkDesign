package step_definitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterItemsPage;
import utils.BrowserUtils;
import utils.DButils;
import utils.Driver;

public class EditItems {
	AddItems newItem = new AddItems();
	String newItemName = newItem.newItemName;
	CraterItemsPage itemsPage = new CraterItemsPage();
	BrowserUtils utils = new BrowserUtils();
	DButils dbutils;
	
	@When("User clicks on the more icon")
	public void user_clicks_on_the_more_icon() {
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		itemsPage.moreButton.click();
		
	}
	@When("USer clicks on Edit button")
	public void u_ser_clicks_on_edit_button() {
		//Driver.getDriver().findElement(By.xpath("//tr[@class='bg-white']/td/a[@class='font-medium text-primary-500']")).click();
		itemsPage.editButton.click();
	}
	@Then("User should see Edit Item page components")
	public void user_should_see_edit_item_page_components() {
		Assert.assertTrue(itemsPage.editItemHeaderText.isDisplayed());
	}
	@Then("USer should be able to edit items")
	public void u_ser_should_be_able_to_edit_items() throws InterruptedException {
		String itemNewName = "NewLaptop";
		// first clear the existing message
		itemsPage.addItemNameField.clear();
		//utils.clearTextOfAFieldMac(itemsPage.addItemNameField);
		Thread.sleep(1000);
		
		itemsPage.addItemNameField.sendKeys(itemNewName);
		
		String itemNewPrice = "10000";
		// first clear the existing message
		itemsPage.addItemPriceField.clear();
		//utils.clearTextOfAFieldMac(itemsPage.addItemPriceField);
		Thread.sleep(1000);
		
		itemsPage.addItemPriceField.sendKeys(itemNewPrice);
		
		String itemNewDescription = "Latest Version";
		// first clear the existing message
		itemsPage.addItemDescription.clear();
		//utils.clearTextOfAFieldMac(itemsPage.addItemDescription);
		Thread.sleep(1000);
		// send the new description
		itemsPage.addItemDescription.sendKeys(itemNewDescription);
		
	}
	@When("User clicks Update item button")
	public void user_clicks_update_item_button() {
		itemsPage.updateItemButton.click();
	}
	@Then("User should see Update item message")
	public void user_should_see_update_item_message() {
		
		// wait the update success message banner
		utils.waitUntilElementVisible(itemsPage.itemUpdatedSuccessMessage);
		// verify the message banner displays
		Assert.assertTrue(itemsPage.itemUpdatedSuccessMessage.isDisplayed());
	}
	
	@Then("User should be able to view new added item")
	public void user_should_be_able_to_view_new_added_item() {
		WebElement newItem = Driver.getDriver().findElement(By.xpath("//a[contains(text(),'NewLaptop')]"));
		Assert.assertTrue(newItem.isDisplayed());
	}
	
	@Then("Added new item should be created in the database")
	public void added_new_item_should_be_created_in_the_database() {
		dbutils = new DButils();
		String query = "SELECT * FROM items WHERE name='NewLaptop';";
		List<String> itemsData = dbutils.selectArecord(query);
		//System.out.println(itemsData);
		
		Assert.assertEquals(itemsData.get(1), "NewLaptop");
		Driver.getDriver().close();
	}

}
