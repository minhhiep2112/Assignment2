package com.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class testDataProvider {

	@DataProvider(name="testdata")
	public String[][] dataProvider() throws IOException {
		
		FileInputStream file = new FileInputStream("./data/assignment2_data_test.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet loginSheet = wb.getSheet("Login");
		
		int numberOfRow = loginSheet.getPhysicalNumberOfRows();
		String [][] testdata = new String [numberOfRow][2];
		
		for(int i=0;i<numberOfRow;i++) {
			
			XSSFRow row = loginSheet.getRow(i);
			XSSFCell email = row.getCell(0);
			XSSFCell pass = row.getCell(1);
			
			testdata[i][0] = email.toString();
			testdata[i][1] = pass.toString();
		
		}
		wb.close();
		
		return testdata;
		
		
	}
	
	
}
