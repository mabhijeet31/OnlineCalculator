package com.calculator.abhijeet.stepdefintion;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;

import com.calculator.abhijeet.selenium.pageobjects.Calculator;
import com.calculator.abhijeet.selenium.pageobjects.StartPage;
import com.calculator.abhijeet.test.selenium.SeleniumTestWrapper;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Minus_DivisionFunctionalityStepDefinition extends SeleniumTestWrapper {

	StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);

	// @Autowired
	// Calculator calculator;
	Calculator calculator = PageFactory.initElements(getDriver(), Calculator.class);

	@Given("^I navigate to calcultor page$")
	public void i_navigate_to_calcultor_page() {
		startPage.open();
		calculator.pageLoadStatus();
	}

	@When("^I substract \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_substract_with(String arg1, String arg2) throws InterruptedException, FindFailed {
		calculator.minusOperationFunction(arg1, arg2);

	}

	@Then("^I validate the result \"([^\"]*)\"$")
	public void i_validate_the_result(String result) throws InterruptedException {
		assertTrue(calculator.verifyOperationResult(result));
	}

	@When("^I division \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_division_with(String arg1, String arg2) throws FindFailed, InterruptedException {
		calculator.divisionOperationFunction(arg1, arg2);

	}
	
	@Then("^I validate the clear button$")
	public void i_validate_the_clear_button()  {
		assertTrue(calculator.verifyClearButtonOperation());
	}


	@After
	public void closeBrowser() {
		getDriver().quit();
	}

}
