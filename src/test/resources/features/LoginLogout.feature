
@LoginLogoutTest
Feature: LoginLogout Functionality 

@checkUIcomponent 
Scenario: Prime Tech Invoice App Login UI Components

Given user is on login page

Then Login page shows page title 
And  Text1 box with the Label Email 
And  Text2 box with the Label ‘Password’
And  Copy right text shows on the page
And Heading1 located to the right
And Heading2 located underneath of heading1

@validUserTest
Scenario: Login as a user with valid credentials
Given: User is on login page
When: user enters valid :sharon6170@gmail.com and password: Test1234
And: user clicks Login button
Then: user will be on the dashboard
Then: user quit the browser


@invalideUserTest
Scenario:Login as a user with invalid credentials
Given: User is on login page
When: user enters invalide :didngietiv@yahoo.com and password:Hello4556
And: user clicks login button
Then: user will see red message error 
Then: user will see red close button on top of red message


@invalidEmptyLogin
Scenario: Login with empty input
Given: user is on login page
When: user leaves empty username and password
Then: user clicks login button
Then: Fields required error message
Then:  User quits the browser


 

