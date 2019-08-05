Feature: verify division function of the calculator 

Scenario: 001 - Test to verify division function 

	Given I navigate to calcultor page 
	When I division "9" with "3" 
	Then I validate the result "3" 
	
	
Scenario: 002 - Test to verify division function 

	Given I navigate to calcultor page 
	When I division "8" with "5" 
	Then I validate the result "1.6" 
	
	
	
Scenario: 003 - Test to verify division function 

	Given I navigate to calcultor page 
	When I division "0" with "4" 
	Then I validate the result "4" 
	
	
