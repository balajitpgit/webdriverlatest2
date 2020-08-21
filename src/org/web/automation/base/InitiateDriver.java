package org.web.automation.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.web.automation.library.PropertyReader;

public class InitiateDriver {
	public WebDriver driver;
	
	@BeforeMethod
	public void startBrowser() throws InterruptedException, IOException {
		if(PropertyReader.applicationConfigReader("BrowserName").equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
			driver = new ChromeDriver();		//<--------------------Browser will open
		}
		else if(PropertyReader.applicationConfigReader("BrowserName").equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
			driver = new FirefoxDriver();		//<--------------------Browser will open
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
			driver = new ChromeDriver();		//<--------------------Browser will open
		}
			
		driver.get(PropertyReader.applicationConfigReader("Application_URL")); //<--------------------URL will be launched
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
}
