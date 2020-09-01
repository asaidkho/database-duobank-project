#Author: Gunel

Feature: Checking Application details



  Background:
  Given I am on the mainpage
  When I log in to account
  
@db
   Scenario: Checking Users Application details
    When I land on a Dashboard I click on Application list
    When I click View Details to open application
    Then I verify Application details are matching with Application details in the DB

