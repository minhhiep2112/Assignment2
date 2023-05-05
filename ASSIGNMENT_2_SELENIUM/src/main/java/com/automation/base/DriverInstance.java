package com.automation.base;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.automation.pom.LoginPage;
import com.automation.utils.CaptureScreenshot;
import com.automation.utils.PropertiesFileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverInstance {
	protected WebDriver driver;
	protected LoginPage login;
	@BeforeClass
	public void initDriverInstance() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.navigate().to(PropertiesFileUtils.getProperty("base_url"));
		
		login = new LoginPage(driver);
		
		
	}
	
		
	@AfterClass
	public void closeDriverInstance() {
		
		driver.quit();
		
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result)  {
		
		if(ITestResult.FAILURE==result.getStatus()) {
			
			String email = (String) result.getParameters()[0];
			String name = email.substring(0, email.indexOf("@"));
			
			CaptureScreenshot.takeScreenShot(driver, name);
		
		}
		
	}
}
