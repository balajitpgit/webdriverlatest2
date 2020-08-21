package org.web.automation.library;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Compare {
	
//To compare current URL with expected URL	
public static boolean compareURL(WebDriver driver, String ExpURL) {
	boolean result = false;
	if(driver.getCurrentUrl().equalsIgnoreCase(ExpURL))
		result = true;
	return result;
}

//To compare current pagetitle with expected title
public static boolean validatePageTitle(WebDriver driver, String ExpURL) {
	boolean result = false;
	if(driver.getTitle().equalsIgnoreCase(ExpURL))
		result = true;
	return result;
}


//To check whether element exists or not using Xpath
public static boolean validateElement(WebDriver driver, String Xpath) {
	boolean result = false;
	try {
		driver.findElement(By.xpath(Xpath));
		result = true;
	}
	catch(Exception e)
	{
		System.out.println("No such element exists");
	}
	return result;
}


}
