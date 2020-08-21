package org.web.automation.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.web.automation.library.Compare;

public class TC_008_Functionality8_Actions_Mouse_Click {

	ChromeDriver driver;
	boolean result;
	
	@BeforeMethod
	public void startBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
		driver = new ChromeDriver();		//<--------------------Browser will open
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/"); 	//<--------------------URL will be launched		
	}
	
	@AfterMethod
	public void closeBrowser() {
	//	driver.quit();
	}
	
	
	@Test
	public void tc001() {
		
		result = Compare.compareURL(driver, "https://www.facebook.com/");
		Assert.assertTrue(result);
		SoftAssert assertion = new SoftAssert();	//<-------------Soft assertion. Execution will continue even if this fails. but test case fails.
		assertion.assertTrue(false, "Not matching");
		driver.findElementByName("firstname").sendKeys("Pranav");
		Actions act = new Actions(driver);
		act.click(driver.findElementByXPath("//input[@aria-label='Log In']")).perform();   //<----single click
		act.doubleClick(driver.findElementByXPath("//input[@aria-label='Log In']")).perform();    //<<----double click
		act.contextClick(driver.findElementByXPath("//input[@aria-label='Log In']")).perform();   //<----right click
		
		assertion.assertAll(); //<----To execute all soft assertions.
		
	}
}


