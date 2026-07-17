package com.ditto.page;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ditto.utility.DriverManager;

public class BasePage {
	public WebDriver driver;
	public JavascriptExecutor js;
	public WebDriverWait wait;
	public Actions action;
	public TakesScreenshot screenshot;
	
	public BasePage() {
		driver = DriverManager.getDriver();
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		action = new Actions(driver);
		screenshot= (TakesScreenshot) driver;

	}

	public void clickOn(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView", element);
		element.click();

	}

	public void clickOn(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		js.executeScript("arguments[0].scrollIntoView", element);
		element.click();

	}

	public void clickUsingJsExecutor(By locator) {
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		js.executeScript("arguments[0].scrollIntoView", element);
		js.executeScript("arguments[0].click()", element);

	}
	
	public void enterText(By locator, String textToEnter) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(textToEnter);
	}
	
	public void enterText(By locator, int textToEnter) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(String.valueOf(textToEnter));
	}
	
	public void scrollTheSlider(By locator, int xOffset) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		action.clickAndHold(element).moveByOffset(xOffset,0).release().build().perform();
	}
	
	public List<WebElement> getAllElements(By locator) {
	List<WebElement> elementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return elementList;
	}
	
	public String takeScreenshot(String name) {	
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String Path = "." + File.separator + "screenshots" + File.separator + name + "-" + timeStamp + ".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		File screenShotFile = new File(Path);
		try {
			FileUtils.copyFile(screenshotData, screenShotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Path;
	}
	


}
