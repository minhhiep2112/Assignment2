package com.automation.utils;

import java.io.File;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

public class CaptureScreenshot {
	
	static String filePath;
	
	public static void takeScreenShot(WebDriver driver, String name) {
		
		try {
			
			Calendar c = Calendar.getInstance();
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File f =  screenshot.getScreenshotAs(OutputType.FILE);
			filePath = "./screenshots//"+ name + " "+ c.getTime().toString().replace(":", "_").replace(" ", "_") +".png";
			File fs = new File(filePath);
			FileUtils.copyFile(f, fs);
		}
			catch(Exception e)		{
				System.out.println("Not able to take screenshot!");
				e.printStackTrace();
			}
			
		
			attachScreenShotToTheReport();
		}

	public static void attachScreenShotToTheReport(){
		
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			// Lấy ra file ảnh theo đường dẫn
			File file = new File(filePath);
			
			// Chèn thẻ <a chứa title và đường dẫn đến thư mục chứa ảnh
			Reporter.log("<br> <a title= \"screenshots\" href=\"" + file.getAbsolutePath() + "\">");
			
			// Chèn thể <img để chỉnh ảnh theo kích thước mong muốn
			Reporter.log("<img alt='"+ file.getName() + "' src='" + file+ "' height='240' width='418'/><br>");
			
			
		}
		catch(Exception e)		{
			System.out.println("Not able to take screenshot!");
			e.printStackTrace();
		}
		
	}
		
}
	

