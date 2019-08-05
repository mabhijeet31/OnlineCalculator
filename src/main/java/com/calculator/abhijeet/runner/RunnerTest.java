package com.calculator.abhijeet.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/resources/features",
		glue={"com.calculator.abhijeet.stepdefintion"},
		plugin={"pretty","json:target/report/cucumber.json","html:target/output","junit:target/junit/cucumber.xml"}
		)
public class RunnerTest {

}