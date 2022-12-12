package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.Smartphone;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Spbase {
	Smartphone sp;
	WebDriver Driver;
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void Setup(String Browser,String Url) {
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			Driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			Driver=new EdgeDriver();
		}
		
		Driver.manage().window().maximize();
		Driver.get(Url);
	}
	
	@AfterClass
	public void setdown() throws InterruptedException {
		Thread.sleep(3000);
		Driver.quit();
	}

}
