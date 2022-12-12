package com.qa.testscripts;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.Smartphone;
import com.qa.utility.ExcelUtility;

public class TC_Smartphone_001 extends Spbase{
	Smartphone sp;
	@DataProvider(name="Data")
	public String[][]getData() throws IOException{
		String xFile="C:\\Users\\rajku\\eclipse-workspace2\\SmartPhone\\src\\test\\java\\com\\qa\\testdata\\ExcelBook.xlsx";
		String xSheet="Sheet1";

		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for(int i=1; i<=rowCount; i++) {
			for(int j=0;j<cellCount;j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;
	}
	
	@Test(dataProvider="Data")
	public void searchproducts(String Category,String ItemName ) {
	
	sp=new Smartphone(Driver);
	Select slct=new Select(sp.dropdown());
	slct.selectByVisibleText(Category);
	sp.Searchbox().sendKeys(ItemName+Keys.ENTER);
	System.out.println("========================================");
	System.out.println("Results for"+ItemName);
	int i=1;
	for(WebElement ww:Smartphone.phones) {
	System.out.println("\n"+i+" . "+ww.getText());
	i++;
	}
	
	sp.Searchbox().clear();
	
	}
	
	

}
