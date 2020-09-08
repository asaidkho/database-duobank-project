
Feature: Test of signup feature for both DB and UI

 

  @db
  Scenario Outline: Test of signup feature
    Given I am on the login page2
    And I click on the sign up link
    When I fill out the field with the following data and click on submit
    		| fname  	| lname 	| email  	| password 		|
    		| <fname> | <lname>	| <email>	| <password>	|
    Then I get to the account page
    And Database is supposed to have the data provided on sign up page

    Examples: 
      | fname  	| lname 	| email  								| password 	|
      | Roger 	| Federer | rfederer@tennis.com 	|	roger123	|
      | Rafael 	| Nadal		| rnadal@tennis.com	    | rafael123	|
