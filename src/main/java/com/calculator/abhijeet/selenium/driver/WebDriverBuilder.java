package com.calculator.abhijeet.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.EdgeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import io.github.bonigarcia.wdm.MarionetteDriverManager;
import io.github.bonigarcia.wdm.OperaDriverManager;

/***
 * 
 * @author Abhijeet More
 *
 */
public class WebDriverBuilder {

    @SuppressWarnings("unused")
	private String name;
    private final WebDriverConfig webDriverConfig;
    
    public WebDriverBuilder(WebDriverConfig webDriverConfig) {
        this.webDriverConfig = webDriverConfig;
    }

    public void setName(String name) {
        this.name = name;
    }

     public WebDriver toWebDriver() {
        DesiredCapabilitiesFactory desiredCapabilitiesFactory = new DesiredCapabilitiesFactory();
        DesiredCapabilities capabilities = desiredCapabilitiesFactory.initDesiredCapabilities(webDriverConfig);
        String browser = webDriverConfig.getBrowserName();

        switch (browser) {
            case "chrome":
                ChromeDriverManager.getInstance().setup();
                final ChromeDriver chromeDriver = new ChromeDriver(capabilities);
                chromeDriver.manage().window().maximize();
                return chromeDriver;
            case "edge":
                EdgeDriverManager.getInstance().setup();
                final EdgeDriver edgeDriver = new EdgeDriver(capabilities);
                edgeDriver.manage().window().maximize();
                return edgeDriver;
            case "internetexplorer":
                InternetExplorerDriverManager.getInstance().setup();
                final InternetExplorerDriver internetExplorerDriver = new InternetExplorerDriver(capabilities);
                internetExplorerDriver.manage().window().maximize();
                return internetExplorerDriver;
            case "opera":
                OperaDriverManager.getInstance().setup();
                final OperaDriver operaDriver = new OperaDriver(capabilities);
                operaDriver.manage().window().maximize();
                return operaDriver;
            
            default:
                MarionetteDriverManager.getInstance().setup();
                FirefoxDriver firefoxDriver = new FirefoxDriver(capabilities);
                firefoxDriver.manage().window().maximize();
                return firefoxDriver;
        }
    }
}
