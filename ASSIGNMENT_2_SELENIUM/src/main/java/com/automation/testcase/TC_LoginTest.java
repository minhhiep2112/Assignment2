package com.automation.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.base.DriverInstance;
import com.automation.utils.PropertiesFileUtils;
import com.automation.utils.testDataProvider;

public class TC_LoginTest extends DriverInstance{
	
	@Test(dataProvider = "testdata", dataProviderClass = testDataProvider.class)
	public void TC01_LoginFirstAccount(String email, String pass) throws IOException  {
		
			Assert.assertTrue(driver.findElement(By.xpath(PropertiesFileUtils.getProperty("signup_login_button_path"))).isDisplayed());
			login.openLoginPage();
			login.enterEmail(email);
			login.enterPassword(pass);
			login.clickSignIn();
			Assert.assertTrue(driver.findElement(By.xpath(PropertiesFileUtils.getProperty("sign_out_button_path"))).isDisplayed());
			login.clickSignOut();
		
				
		
		
	}
	
	
}
