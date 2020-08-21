package org.web.automation.testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_Registration_Functionality5_Dropdown {

	ChromeDriver driver;
	
	@BeforeMethod
	public void startBrowser() throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\bs112524\\Desktop\\Selenium\\chromedriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe"); //<------------------Pointing chromedriver.exe to webdriver
		driver = new ChromeDriver();		//<--------------------Browser will open
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/"); 	//<--------------------URL will be launched		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	
	@Test
	public void tc001() {
		driver.findElementByName("firstname").sendKeys("Pranav");
		driver.findElementByXPath("//span[@class='_5k_2 _5dba'][2]/input").click();
		driver.findElementByXPath("//button[@name='websubmit']").click();
	}
}


