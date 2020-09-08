#Author: Alex

Feature: DataBase test of Mortgage Application

	Background:
		Given I am on the homepage
   	And I login

  @db
  Scenario Outline: Verify Mortgage Application data in DB	
    Given I click  on Mortgage Application on the Dashboard
    When I fill out the Mortgage Application step by step, and agreed with eDisclosure Agreement
    	| <row> |
    And Click Save to submit the application
    Then The data user entered into the Mortgage Application should be reflect accordingly in database with the correct information about user Mortgage Application entry
    | <row> |
    
   Examples:
   	| row  |
   	| 1    |
   	| 2    |
 #  	| 3    |
 #   	| 4    |
  #  	| 5    |
 #   	| 6    |
 #   	| 7    |
  #  	| 8    |
 #   	| 9    |
 #  	| 10   |
   	   	