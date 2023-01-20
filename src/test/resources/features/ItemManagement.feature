
@ItemManagement
Feature: Item Management
  I want to allow Prime Tech Invoice App users to create items.

 @LandingPageUI
  Scenario: Landing Page UI components
    Given User enters valid credentials
    And clicks on login
    When User clicks Items Menu link
    Then User should be on Items page
    And User should see other Items page elements
@AddItemUI
Scenario: Add Items UI components
    Given User enters valid credentials
    And clicks on login
    When User clicks Items Menu link
    And User clicks Add Item button
    Then User should see Add Item page components
    
    @AddItem
    Scenario Outline: Add Items 
    Given User enters valid credentials
    And clicks on login
    When User clicks Items Menu link
    And User clicks Add Item button
    And User enters details for "<name>" field, "<price>" field, "<unit>" field and "<description>" field
    And User clicks save item button
    Then User should see a flash message
    And User should be on Items Page
    And User should be able to view added item
    And Added item should be created in the database
    
    Examples: 
      | name        | price   | unit    | description                 |
      | Tennis ball |   500   | pc     | Only to be used for practise|
      | Laptop      |   70000 | pc     | Gaming laptop               |
    
    @EditItem
Scenario: Edit Items
    Given User enters valid credentials
    And clicks on login
    When User clicks Items Menu link
    And User clicks on the more icon
    And USer clicks on Edit button
    Then User should see Edit Item page components
    And USer should be able to edit items
    When User clicks Update item button
    Then User should see Update item message
     And User should be on Items Page
    And User should be able to view new added item
    And Added new item should be created in the database

 @DeleteItem
Scenario: Delete Items
    Given User enters valid credentials
    And clicks on login
    When User clicks Items Menu link
    And User should be on before delete Items page
    And User clicks on the more icon
    And USer clicks on Delete button
    Then User is shown a modal message with Ok and cancel buttons
    When User click on cancel button
    Then User should be on Items page
    When User clicks on the more icon
    And USer clicks on Delete button
    Then User is shown a modal message with Ok and cancel buttons
    When User clicks Ok button
    Then User should see Delete item message
    
    And User should be on after delete Items page
    And User should not see Deleted Item
   
