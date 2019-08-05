Feature: verify minus function of the calculator 

Scenario: 001 - Test to verify minus function 

	Given I navigate to calcultor page 
	When I substract "9" with "5" 
	Then I validate the result "4" 
	
	
Scenario: 002 - Test to verify minus function 

	Given I navigate to calcultor page 
	When I substract "2" with "8" 
	Then I validate the result "-6" 
	
	
	
Scenario: 003 - Test to verify minus function 

	Given I navigate to calcultor page 
	When I substract "0" with "5" 
	Then I validate the result "-5" 
	
	
