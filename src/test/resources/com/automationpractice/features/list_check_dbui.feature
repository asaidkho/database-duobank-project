Feature: Test the list for the correct entries

@db
Scenario: Test list

Given I login to the website
And I click on the Application List link
Then Borrower Name and Loan Amount in the list must match database entries



