package org.web.automation.testcases;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_Functionality6_Actions_combined {

	ChromeDriver driver;
	
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
	
		driver.findElementByName("firstname").sendKeys("Pranav");
		Actions act = new Actions(driver);
		act.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).build().perform();  //<--------combined key entries
		
	}
}


