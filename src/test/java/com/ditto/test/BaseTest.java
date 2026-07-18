package com.ditto.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ditto.utility.DriverManager;

public class BaseTest {

	
	@BeforeMethod
	public void setup() {
	DriverManager.setDriver("chrome");

	DriverManager.getDriver().get("https://app.joinditto.in/fq");
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		
		DriverManager.quitDriver();
	}
	

}
