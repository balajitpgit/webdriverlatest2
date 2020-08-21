package org.web.automation.library;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class CaptureScreenshot {

	public static void takeScreenshot(WebDriver driver) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		Calendar cal = Calendar.getInstance();
		File fd = new File("./Screenshots/" + new Throwable().fillInStackTrace().getStackTrace()[1].getMethodName().toString() + " - " + cal.getTime().toString().replace(":", "").replace(" ", "") +".png");
		FileUtils.copyFile(f,fd);
	

	}
}
