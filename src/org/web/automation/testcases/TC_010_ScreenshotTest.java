package org.web.automation.testcases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import org.web.automation.base.InitiateDriver;

public class TC_010_ScreenshotTest extends InitiateDriver {

	@Test
	public void tc001() throws InterruptedException, IOException {
		
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File f = screenshot.getScreenshotAs(OutputType.FILE);
		File fd = new File("./Screenshots/screen.png");
		FileUtils.copyFile(f,fd);
	}
}
