package com.calculator.abhijeet.selenium;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.calculator.abhijeet.utils.TestUtils;

/***
 * 
 * @author Abhijeet More
 *
 */
public abstract class SeleniumFunctions {

	protected WebDriver driver;

	public SeleniumFunctions(final WebDriver driver) {
		this.driver = driver;
	}

	private static final int ELEMENT_WAIT_TIMEOUT_IN_SECONDS = 90;
	//private static final int PAGE_WAIT_TIMEOUT_IN_SECONDS = 60;
	
	protected boolean isElementPresent(final WebElement element) {
		try {
			waitForLoad();
			highlightElement(element);
			element.getTagName();
		} catch (final NoSuchElementException ignored) {
			return false;
		} catch (final StaleElementReferenceException ignored) {
			return false;
		}
		return true;
	}
	

	protected boolean isElementVisible(final WebElement element) {
		highlightElement(element);
		return element.isDisplayed();
	}

	protected boolean isAnyTextPresent(final WebElement element) {
		final String text = element.getText();
		return StringUtils.isNotBlank(text);
	}
	
	public String getTextPresent(final WebElement element) {
		highlightElement(element);
		return element.getText().trim();
	}

	public String getCurrentUrl() {
		return this.driver.getCurrentUrl();
	}
	
	public void PageReload() {
		 this.driver.navigate().to(this.driver.getCurrentUrl().toString());
	}
	
	public void pageRefresh() {
		this.driver.navigate().refresh();
	}
	
	protected void waitForElement(final WebElement element) {
		this.waitForElement(element, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
	}

	protected void waitForElement(final WebElement element, final int timeoutInSeconds) {
		final WebDriverWait wait = new WebDriverWait(this.driver, timeoutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	protected void waitForElementLocated(final By element) {
		final WebDriverWait wait = new WebDriverWait(this.driver, ELEMENT_WAIT_TIMEOUT_IN_SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}

	public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                    	 return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("loaded")
                    	            || ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(pageLoadCondition);
    }
	
 	protected JavascriptExecutor highlightElementPermanently(final WebElement element) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
		return js;
	}

	protected void highlightElement(final WebElement element) {
		final String originalStyle = element.getAttribute("style");
		final JavascriptExecutor js = highlightElementPermanently(element);
		TestUtils.sleep(1000);
		js.executeScript("arguments[0].setAttribute('style', '" + originalStyle + "');", element);
	}

	public void clickWebElement(WebElement element) {
		if(isElementPresent(element)) {
			element.click();
		//	waitForElement(element);
		}
	}
	
	public void sendValueToElement(WebElement element, String data) {
		if(isElementPresent(element))
			element.sendKeys(data);
	}
	
	public void takeScreenshot(final String path) {
		final File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void scroll(final int x, final int y) {
		final JavascriptExecutor js = (JavascriptExecutor) this.driver;
		for (int i = 0; i <= x; i = i + 100) {
			js.executeScript("scroll(" + i + ",0)");
		}
		for (int j = 0; j <= y; j = j + 100) {
			js.executeScript("scroll(0," + j + ")");
		}
	}
	
	
	public void selectElementFromDropDown(WebElement element, String value) {
		if(isElementPresent(element)) {
			Select drpCountry = new Select(element);
			drpCountry.selectByValue(value);
		}	
	}
	
	public void selectElementFromDropDownVisibleText(WebElement element, String value) {
		if(isElementPresent(element)) {
			Select drpCountry = new Select(element);
			drpCountry.selectByVisibleText(value);
		}	
	}

	public  List<WebElement> listOfElements(final String xpath) {
		return this.driver.findElements(By.xpath(xpath));	
		}
	
}
