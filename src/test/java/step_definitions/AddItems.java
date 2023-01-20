package step_definitions;

import java.util.List;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CraterItemsPage;
import utils.BrowserUtils;
import utils.DButils;
import utils.Driver;

public class AddItems {
	CraterItemsPage itemsPage = new CraterItemsPage();
	BrowserUtils utils = new BrowserUtils();
	DButils dbutils;
	String newItemName;
	@When("User enters details for {string} field, {string} field, {string} field and {string} field")
	public void user_enters_details_for_field_field_field_and_field(String name, String price, String unit, String description) throws InterruptedException {
		Thread.sleep(3000);
		
		newItemName = name + utils.randomNumber();
		itemsPage.addItemNameField.sendKeys(newItemName);
		itemsPage.addItemPriceField.sendKeys(price);
		itemsPage.addItemUnitField.sendKeys(unit, Keys.ENTER);
		//itemsPage.pc_unit.click();
		itemsPage.addItemDescription.sendKeys(description);
	}
	
	@When("User clicks save item button")
	public void user_clicks_save_item_button() {
		itemsPage.saveItemButton.click();
	}
	@Then("User should see a flash message")
	public void user_should_see_a_flash_message() {
		utils.waitUntilElementVisible(itemsPage.itemCreateSuccessMessage);
	Assert.assertTrue(itemsPage.itemCreateSuccessMessage.isDisplayed());
	}
	@Then("User should be on Items Page")
	public void user_should_be_on_items_page() {
		  Assert.assertTrue(itemsPage.itemsHeaderText.isDisplayed());
	}
	@Then("User should be able to view added item")
	public void user_should_be_able_to_view_added_item() {
		WebElement newItem = Driver.getDriver().findElement(By.xpath("//a[text()='"+newItemName+"']"));
		Assert.assertTrue(newItem.isDisplayed());
		
	}
	@Then("Added item should be created in the database")
	public void added_item_should_be_created_in_the_database() {
		dbutils = new DButils();
		String query = "SELECT * FROM items WHERE name='"+newItemName+"';";
		List<String> itemsData = dbutils.selectArecord(query);
		//System.out.println(itemsData);
		
		Assert.assertEquals(itemsData.get(1), newItemName);
		Driver.getDriver().close();
	}


}
