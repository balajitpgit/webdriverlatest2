package org.web.automation.testcases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_001_Registration_Functionality4_RadioButton {

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
		WebElement firstname = driver.findElementByName("firstname");
		firstname.sendKeys("Pranav");
		driver.findElementByXPath("//span[@class='_5k_2 _5dba'][2]/input").click();
		driver.findElementByXPath("//button[@name='websubmit']").click();
		Select Month = new Select(driver.findElementByXPath("//select[@aria-label='Month']"));
		//Month.selectByIndex(4); //1st Approach - to choose by index number
		//Month.selectByValue("4"); //2nd Approach - to choose by value set in html page
		Month.selectByVisibleText("Mar");
		System.out.println("Current URL is	----->:" + driver.getCurrentUrl());
		System.out.println("Current Page Title is	----->:" + driver.getTitle());					
		
		//System.out.println("Current complete page source is------->:" + driver.getPageSource());   //<----------------To fetch complete HTML page source
		System.out.println("Inner text is------>:" + driver.findElementByXPath("//a[contains(text(),'Forgot')]").getText());	//<-----------------Inner text of the webelement
		System.out.println("aria-label attribute of this web element is------------->"+ driver.findElementByName("firstname").getAttribute("aria-label"));
		System.out.println("Coordinates of web element is------------->"+ driver.findElementByName("firstname").getLocation());
		System.out.println(driver.findElementByName("firstname").isDisplayed());
		//System.out.println(driver.findElementByXPath("//input[@name='lgnrnd']").isDisplayed());
		System.out.println(driver.findElementByXPath("//select[@aria-label='Month']").isSelected());
		
		System.out.println(Month.getFirstSelectedOption().getText());  //<------print selected value in dropdown/list
		
		List<WebElement> Monthlist = Month.getAllSelectedOptions();   //<----------To print selected values in dropdown/list
		for(WebElement m: Monthlist)
		{
			System.out.println(m.getText());
		}
		
		List<WebElement> Monthlistall = Month.getOptions();   //<----------To print all values in dropdown/list
		for(WebElement m: Monthlistall)
		{
			System.out.println(m.getText());
		}
	}
}


