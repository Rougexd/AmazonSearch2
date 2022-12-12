package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Smartphone {
	WebDriver Driver;
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	WebElement searchbox;
	public  WebElement Searchbox() {
	 return searchbox;
	}
	 
	
	@FindBy(xpath="//div[@class='nav-search-scope nav-sprite']//select[1]")
	WebElement Dropdown;
	public WebElement dropdown() {
		return Dropdown;
	}
	
	@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
	
	public  static List<WebElement >phones;
	
	public Smartphone(WebDriver Driver) {
		this.Driver=Driver;
		PageFactory.initElements(Driver, this);
	}
	

}
