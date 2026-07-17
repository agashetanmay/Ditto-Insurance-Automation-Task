package com.ditto.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ditto.utility.DriverManager;

public class BaseTest {
	public WebDriver wd;
	
	@BeforeMethod
	public void setup() {
	DriverManager.setDriver("chrome");
	wd = DriverManager.getDriver();
	wd.get("https://app.joinditto.in/fq");
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		DriverManager.quitDriver();
	}
	

}
