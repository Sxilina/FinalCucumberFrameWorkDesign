@tag
Feature: customerservice api test
  

  @tag1
  Scenario: createcustomer api
    When I send a request to the Creator customer with the ‘POST’ HTTP method,
    Then I should get 200 status code
    And The customer should be created in the application database.