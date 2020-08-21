package org.web.automation.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_Registration_Functionality2_Firefox {

	ChromeDriver driver;
	
	@BeforeMethod
	public void startBrowser() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\bs112524\\Desktop\\Selenium\\chromedriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
		driver = new ChromeDriver();		//<--------------------Browser will open
		driver.manage().window().maximize();
		//driver.get("https://www.facebook.com/"); 	//<--------------------URL will be launched
		driver.navigate().to("https://www.google.com/"); 	//<--------------------URL will be launched
		driver.navigate().to("https://www.facebook.com/"); 	//<--------------------URL will be launched
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();	
		Thread.sleep(5000);
		driver.navigate().refresh();
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		//driver.close();
		driver.quit();
	}
	
	
	@Test
	public void tc001() {
		driver.findElementByName("firstname").sendKeys("Pranav");
		driver.findElementByXPath("//button[@name='websubmit']").click();
	}
}


