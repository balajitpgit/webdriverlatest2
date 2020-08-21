package org.web.automation.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.web.automation.base.InitiateDriver;
import org.web.automation.library.*;

public class TC_009_Functionality9_Actions_Mouse_Moveover extends InitiateDriver {

	
	
	
	@Test
	public void tc001() throws InterruptedException, IOException {
	
		driver.findElement(By.name(PropertyReader.elementConfigReader("login_page_firstname_name"))).sendKeys(PropertyReader.applicationConfigReader("Application_Username"));
		//Thread.sleep(10000);
		//Actions act = new Actions(driver);
		//act.sendKeys(Keys.PAGE_DOWN).perform();
		//act.moveToElement(driver.findElement(By.xpath("//a[@class='_sv4' and @title='Tamil']"))).perform();
		//Thread.sleep(5000);
		CaptureScreenshot.takeScreenshot(driver);
		
	}
}


