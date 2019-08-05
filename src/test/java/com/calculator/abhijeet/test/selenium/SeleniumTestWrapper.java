package com.calculator.abhijeet.test.selenium;

import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;

import com.calculator.abhijeet.selenium.driver.WebDriverConfig;
import com.calculator.abhijeet.selenium.utils.WebDriverProvider;
import com.calculator.abhijeet.selenium.utils.annotations.RepeatRule;
import com.calculator.abhijeet.selenium.utils.annotations.browser.Browser;
import com.calculator.abhijeet.selenium.utils.annotations.browser.BrowserDimension;
import com.calculator.abhijeet.selenium.utils.annotations.browser.Browsers;
import com.calculator.abhijeet.test.configurations.TestConfig;



public abstract class SeleniumTestWrapper {

	protected static final TestConfig testConfig = new TestConfig();
	private final WebDriverConfig webDriverConfig = new WebDriverConfig();
	protected final WebDriverProvider webDriverProvider = new WebDriverProvider(this.webDriverConfig);

	@Rule
	public RepeatRule repeatRule = new RepeatRule();

	protected WebDriver getDriver() {
		return this.webDriverProvider.getDriver();
	}

	@Before
	public void browser() throws Exception {
		Browser browser = this.getClass().getAnnotation(Browser.class);
		if (browser != null) {
			if (browser.require().length > 0 && browser.skip().length == 0) {
				String browsers = concatinateBrowsers(browser.require());
				assumeTrue("only execute test against " + browsers, browsers.contains(testConfig.getBrowser()));
			}

			if (browser.skip().length > 0 && browser.require().length == 0) {
				String browsers = concatinateBrowsers(browser.skip());
				assumeFalse("skip test against " + browsers, browsers.contains(testConfig.getBrowser()));
			}
		}
	}

	private String concatinateBrowsers(Browsers[] browsers) {
		String concatinatedBrowsers = "";
		for (Browsers browser : browsers)
			concatinatedBrowsers += browser.getValue() + " & ";
		return concatinatedBrowsers.substring(0, concatinatedBrowsers.lastIndexOf("&"));
	}

	@Before
	public void browserDimension() {
		BrowserDimension browserDimension = this.getClass().getAnnotation(BrowserDimension.class);
		if (browserDimension != null) {
			getDriver().manage().window().setSize(browserDimension.value().dimension);
		}
	}

	@After
	public void closeBrowser() {
		getDriver().quit();
	}

}
