package org.web.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.web.automation.base.InitiateDriver;

public class TC001 extends InitiateDriver {

	@Test
	public void tcase1() {
		//Approach1
		//LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		
		//Approach2
		LoginPage login = new LoginPage();
		PageFactory.initElements(driver, login);
		
		
		login.enterUserName();
		login.enterPassword();
		
	}
}
