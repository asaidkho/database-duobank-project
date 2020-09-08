#Author: Gunel
Feature: API Test Feature

  #Scenario: Test  API create new user
    Given I am on login page
    When I sent POST request to create new user
      | first_name | last_name | email            | password   |
      | Melania    | Trump     | mtrump@gmail.com | melania123 |
    Then New user is sucsessfully created
