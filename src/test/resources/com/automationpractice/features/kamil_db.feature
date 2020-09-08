
Feature: Two db tests
	
	@db
 Scenario: Test that nobody in database tbl_mortagage is under 16
  
    Then There should be nobody in the database tbl_mortagage who is under 16
   

 @db
  Scenario: Email is in valid format test
   Then Email of the borrowers must have valid formats

    
