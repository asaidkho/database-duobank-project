#Author: Alex

Feature: DB Tests 

  @db
  Scenario: Test Borrower phone number has to be nine digit
    Then Borrower phone number is nine digit in xxx-xx-xxxx format
 
  @db
  Scenario: Test SSN can not be empty 
    Then SSN is filled out and follow xxx-xx-xxxx format


