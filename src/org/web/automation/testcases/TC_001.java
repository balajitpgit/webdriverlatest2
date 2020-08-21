package org.web.automation.testcases;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import listener.DriverUpdate;
import listener.ModifiedTestNGListener;

@Listeners(ModifiedTestNGListener.class)
public class TC_001 {

	@Test
	public void testcase1() {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		
		DriverUpdate listener = new DriverUpdate();
		
		eventDriver.register(listener);
		
		eventDriver.navigate().to("https://www.facebook.com/");
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", ""); //To scroll down page by 200 pixels using java script executor
		js.executeScript("alert('TestingWorld');", ""); // To show alert message in web browser using java script executor
		
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println("Number of links present in the page: " + links.size());
		
		int count=0;
		for(WebElement link: links)
		{
			if(link.getAttribute("href")!=null || link.getAttribute("href").contains("javascript"))
			{
				boolean res = this.checkLink(link.getAttribute("href"));
				if(res==false)
				{
					count=count+1;
				}
			}
		}
		System.out.println("Number of broken links in the page: " + count);
	}
	
	public boolean checkLink(String linkURL)
	{
		boolean result = false;
		try
		{
			URL url = new URL(linkURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000);
			conn.connect();
			if(conn.getResponseCode()==200) //Success response on clicking link
			{
				result = true;
			}
			
		}catch(Exception e) {}
		
		return result;
	}
	
	
}
