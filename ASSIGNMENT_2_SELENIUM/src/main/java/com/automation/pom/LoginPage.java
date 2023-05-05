package com.automation.pom;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.automation.utils.PropertiesFileUtils;

public class LoginPage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void enterEmail(String email) throws IOException   {
		
		wait.until(ExpectedConditions.visibilityOf
				(driver.findElement(By.xpath(PropertiesFileUtils.getProperty("login_email_path"))))).sendKeys(email);;
		
		
	}
	
	public void enterPassword( String pass) throws IOException {
	
	
		wait.until(ExpectedConditions.visibilityOf
				(driver.findElement(By.xpath(PropertiesFileUtils.getProperty("login_password_path"))))).sendKeys(pass);;
		
		
	}
	
	public void clickSignIn() throws IOException {
		
		
		wait.until(ExpectedConditions.visibilityOf
				(driver.findElement(By.xpath(PropertiesFileUtils.getProperty("sigin_button_path"))))).click();;
		
		
	}
	
	public  void clickSignOut() throws IOException {
		
		wait.until(ExpectedConditions.elementToBeClickable
				(driver.findElement(By.xpath(PropertiesFileUtils.getProperty("sign_out_button_path"))))).click();
	
	}
	
	public void openLoginPage() throws IOException {
		
		wait.until(ExpectedConditions.elementToBeClickable
				(driver.findElement(By.xpath(PropertiesFileUtils.getProperty("signup_login_button_path"))))).click();
		
	}
	
	
}
