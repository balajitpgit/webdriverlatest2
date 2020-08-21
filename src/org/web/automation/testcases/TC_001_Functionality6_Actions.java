package org.web.automation.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_Functionality6_Actions {

	ChromeDriver driver;
	
	@BeforeMethod
	public void startBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
		driver = new ChromeDriver();		//<--------------------Browser will open
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);   //<---------Page load wait time in seconds
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);   //<-----------Implicitly wait for webelements
		driver.get("https://www.facebook.com/"); 	//<--------------------URL will be launched		
	}
	
	@AfterMethod
	public void closeBrowser() {
	//	driver.quit();
	}
	
	
	@Test
	public void tc001() {
	
		driver.findElementByName("firstname").sendKeys("Pranav");
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
		act.sendKeys("Password1").perform();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.textToBePresentInElement(driver.findElementByName("firstname"), "Pranav"));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElementByName("firstname")));
		
	}
}


