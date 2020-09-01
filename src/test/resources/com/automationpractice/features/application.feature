#Author: Gunel
Feature: Checking Application details

  @db
  Scenario: Checking Users Application details
    Given I am on the mainpage
    When I enter the following  deatils and  I log in
      | email            | password |
      | dtrump@gmail.com | trump123 |
    When I land on a Dashboard I click on Application list
    When I click View Details to open application
    Then I verify Application details are matching with Application details in the DB

  
  Scenario: Checking purpose of loan from db
    Given I retrive purpose_loan  from database
    Then I verify purpose_loan content is "Purchase home"
