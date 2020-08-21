package org.web.automation.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_Registration_Functionality {

	FirefoxDriver driver;
	
	@BeforeMethod
	public void startBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\bs112524\\Desktop\\Selenium\\geckodriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
		driver = new FirefoxDriver();		//<--------------------Browser will open
		driver.get("https://www.facebook.com/"); 	//<--------------------URL will be launched
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
	
	
	@Test
	public void tc001() {
		driver.findElementByName("firstname").sendKeys("Pranav");
		driver.findElementByXPath("//button[@name='websubmit']").click();
	}
}


