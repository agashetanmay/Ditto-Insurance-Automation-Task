package com.ditto.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverManager {
	
private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	
	public static void setDriver(String browserName) {
		
		if(browserName=="chrome") {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
			driver.set(new ChromeDriver(options));	
		}
		if(browserName=="edge") {
			
				driver.set(new EdgeDriver());	
			}
	
	}
	public static WebDriver getDriver() {
		return driver.get();
	}
	
	public static void quitDriver() {
		getDriver().quit();
		driver.remove();
	}
}
