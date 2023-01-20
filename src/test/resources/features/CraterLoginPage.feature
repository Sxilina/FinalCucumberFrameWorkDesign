@LoginPageTest
Feature: LoginPage UI componenet
  Verify the components and function of LoginPage
  

  @CheckUIComponent 
  Scenario: Login Page UI components
    Given user is on the LoginPage
    Then the system should display page title
    And Text box with label email textbox
    And Text box with label password textbox
    And CopyRight text on the bottom left 
    And Heading1 to the right
    And Heading2 underneath Heading1
    
    @validLoginTest 
  Scenario Outline: User is able to login successfully
  	Given user is on the LoginPage
    When user enters valid "abudu.oy@gmail.com" and "Password1234"
    And clicks on the login button
    Then user should be on the dashboard page
    And user quits the browser
    
     @InvalidLoginTest 
  Scenario: User is able to login successfully
  	Given user is on the LoginPage
    When user enters invalid "<useremail>" and "<passweord>"
    And clicks on the login button
    Then invalid credential error messages appear
    And user quits the browser
    
    
    Examples:
    | useremail                  | passweord       | 
    | abudu.oy@gmail.com         | test1234 | 
    | nothing@primetechschool.com| Password1234      |
   
   
   @invalidEmptyLogin 
    Scenario Outline: Invalid login attempts
    Given user is on the LoginPage
    When user leaves useremail "<useremail>" and password "<passweord>" empty
    And clicks on the login button
    Then Field Required error messages appear
    And user quits the browser
    
    Examples:
    | useremail                  | passweord        | 
    | abudu.oy@gmail.com         |  								| 
    |														 | Password1234     |
   	|														 | 						      |
     
     
     @ForgotPassWordLink 
  Scenario: Forgot PassWord Link check
    Given user is on the LoginPage
    And clicks on the Forgot Password ? Link button
    Then Enter email text, Send Reset Link button and Back to Login Link is displayed
    And user quits the browser
    
     @ResetPassword 
  Scenario: Reset PassWord Link check
  	Given user is on the LoginPage
    And clicks on the Forgot Password ? Link button
    When user leaves the email field blank
    And  clicks on the Send Reset Link button
    Then user should see error message Field is required
    When user enters invalid email "primetech"
    Then user should see error message Incorrect Email   
    Given user is on the LoginPage
    And clicks on the Forgot Password ? Link button
    When user enters valid email "abudu.oy@gmail.com"
    And clicks on the Send Reset Link button
    Then user should see success message
    And user quits the browser
    

