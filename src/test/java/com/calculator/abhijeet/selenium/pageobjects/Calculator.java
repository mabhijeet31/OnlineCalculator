package com.calculator.abhijeet.selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.springframework.stereotype.Component;

import com.calculator.abhijeet.selenium.Pages;

/***
 * 
 * @author Abhi
 *
 */

@Component
public class Calculator extends Pages {

	Screen screen = new Screen();
	String fileName;

	public Calculator(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//canvas[@id='canvas']")
	private WebElement eleCanvas;

	@FindBy(xpath = "//span[contains(text(),'images')]")
	private WebElement lblImage;

	public void clickButtonLnk(String value) {

		String path = "./src/test/resources/images/" + selectElement(value);
		Pattern fileInputTextBox = new Pattern(path);

		try {
			screen.wait(fileInputTextBox, 10000);
			screen.click(fileInputTextBox);
		} catch (FindFailed e) {
			e.printStackTrace();
		}

	}

	public void minusOperationFunction(String value1, String value2) throws InterruptedException, FindFailed {

		clickButtonLnk(value1);
		clickButtonLnk("minus");
		clickButtonLnk(value2);
		clickButtonLnk("equal");

	}

	public void divisionOperationFunction(String value1, String value2) throws InterruptedException, FindFailed {

		clickButtonLnk(value1);
		clickButtonLnk("division");
		clickButtonLnk(value2);
		clickButtonLnk("equal");

	}

	public boolean verifyOperationResult(String result) {
		fileName = "./src/test/resources/images/" + selectOutPutElement(result);

		Match m = screen.exists(fileName);
		if (m != null) {
			return false;

		} else {
			return true;
		}

	}

	public boolean verifyClearButtonOperation() {
		fileName = "C:\\Users\\Abhi_Amarr\\eclipse-workspace_HelloFresh\\OnlineCalculator\\src\\test\\resources\\images\\clear.png";

		if (screen.exists(fileName, 2) != null) {
			return false;
		}
		else {
			return true;
		}
	}

	public String selectElement(String value) {
		switch (value) {
		case "0":
			return "zero.png";
		case "1":
			return "one.png";
		case "2":
			return "two.png";
		case "3":
			return "three.png";
		case "4":
			return "four.png";
		case "5":
			return "five.png";
		case "6":
			return "six.png";
		case "7":
			return "seven.png";
		case "8":
			return "eight.png";
		case "9":
			return "nine.png";
		case "minus":
			return "minus.png";
		case "division":
			return "division.png";
		case "equal":
			return "equal.png";
		case "ce":
			return "clear.png";
		default:
			return null;
		}

	}

	public String selectOutPutElement(String value) {
		switch (value) {
		case "4":
			return "answer_4.png";
		case "-6":
			return "minus_six.png";
		case "-5":
			return "minus_five.png";
		case "3":
			return "three.png";
		case "1.6":
			return "one_point_six.png";
		case "0":
			return "zero.png";
		default:
			return null;
		}
	}

	public void pageLoadStatus() {
		waitForLoad();
	}

}
