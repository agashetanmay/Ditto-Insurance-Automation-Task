package com.ditto.page;

import org.openqa.selenium.By;

public class PolicyDetailsPage extends BasePage {

	public static final By NEXT_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Next')]/parent::span/parent::button");
	public static final By WAITING_PERIOD_FULL_LIST_LOCATOR = By.xpath("//span[contains(text(), 'Full list')]/parent::span");
	public static final By WAITING_PERIOD_FULL_LIST_CLOSE_BUTTON_LOCATOR = By.xpath("//span[contains(text(), 'Close')]/parent::span");
	public static final By CONTINUE_BUTTON_LOCAOTR = By.xpath("//span[contains(text(),'Continue')]/parent::span/parent::button");

	public void clickOnMainBenefitNextButton() {
        clickOn(NEXT_BUTTON_LOCATOR);
	}

	public void clickOnWaitingPeriodNextButton() {
		 clickOn(WAITING_PERIOD_FULL_LIST_LOCATOR);
		 clickOn(WAITING_PERIOD_FULL_LIST_CLOSE_BUTTON_LOCATOR);
		 clickOn(NEXT_BUTTON_LOCATOR);
	}
	
	public void clickOnWhatNotCoverNextButton() {
		 clickOn(NEXT_BUTTON_LOCATOR);
	}
	
	public void clickOnExtraBenefitContinueButton() {
		clickUsingJsExecutor(CONTINUE_BUTTON_LOCAOTR);
	}

}
