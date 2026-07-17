package com.ditto.page;

import org.openqa.selenium.By;

public class InsurancePage extends BasePage{

	
	public static final By HEALTH_INSURANCE_LOCATOR = By.xpath("//span[contains(text(), 'Optima Secure +')]/ancestor::div[contains(@class,'mantine-Grid-col')]");
	
	
	
     public void clcikOnOptimaSecureHealthInsurance() {
    	 clickOn(HEALTH_INSURANCE_LOCATOR);
     }
	
}
