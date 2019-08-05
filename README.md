# Following are the Features implemented,
* Multi browser configuration
* BDD implemented using cucumber
* Page object as well as singleton design pattern used.
* Web driver manager plugin used for driver management.
* Surefire Plugin used for report generation.
* Logging mechanish is implemented
* Implemented for all the browser (including headless browser) and all O.S. in the market..
* Reading test data from property file.


#Technology used,
Java 8
Selenium
Cucumber
Maven
Junit(4)
Sikuli


# Implemented Browsers
* Chrome
* Firefox
* Opera


# Pre-requisite: 
* Use below commad to download dependency
===> mvn install -DskipTests=true
* Note: Sometimes get error as "Network not available. Forcing the use of cache"


# How to execute project
1. Execute maven command with chrome browser
===> mvn clean verify -Pbrowser-firefox surefire-report:report
	

# Execution report 
* After execution will get report the in this location "OnlineCalculator\target\site". i.e. "surefire-report.html"


# Test cases details:
* Java, Selenium and mvn ==  GUI testing.
* Verify_CE_Function.feature ==> Verified clear function
* Verify_division_Function.feature ==> Verified division function
* Verify_Minus_Function.feature.feature ==> Verified Minus function
