package com.ditto.page;

import org.openqa.selenium.By;

public class AddFamilyMemberPage extends BasePage {
	
	
	public static final By NEXT_STEP_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Next step')]/parent::span/parent::button");
	public static final  By SELF_MALE_LOCAOTR = By.xpath("//span[contains(text(),'Self')]/parent::div/div/div[(text()='Male')]");
	 
   
     public void selectTheSelfMaleMember() {
    	 clickOn(SELF_MALE_LOCAOTR);
    	 
     }
     
     public void clickOnNextStepButton() {
    	 clickOn(NEXT_STEP_BUTTON_LOCATOR);
    	 
     }

}
