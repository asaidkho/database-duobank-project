#Author: Alex

Feature: Test API

  @db
  Scenario: Test Login API
    Given I am on the login page3
    When I sent POST request for login with valid credentials
      |  email                |  password     |
      | random_dude@gmail.com | T@sk4C0mplit3 |
    Then Login is succesfull and user get an Authorization Token in the response for authentication purpose

