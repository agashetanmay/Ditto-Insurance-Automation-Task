package com.ditto.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalculatePremiumPage extends BasePage {

	public static final By YOUR_AGE_TEXTBOX_LOCATOR = By.xpath("//input[@name='Selfage']");
	public static final By PIN_CODE_LOCATOR = By.xpath("//input[@name='pincode']");
	public static final By NO_LOYALTY_DISCOUNT_LOCATOR = By.xpath("//label[text()='No']/parent::div/parent::div/div/input");
	public static final By COVER_AMOUNT_SLIDER = By.xpath("//div[contains(@class,'m_dd36362e mantine-Slider-root')]");
    public static final By CALCULATE_PREMIUM_LOCATOR = By.xpath("//span[contains(text(),'Calculate Premium')]/parent::span/parent::button");
    
    public static final By ADDON_AND_RIDER_LOCATOR = By.xpath("//span[contains(text(),'Add Ons & Riders')]/ancestor::div[contains(@class,'mantine-Accordion-root')]/div/div");
    public static final By ADDON_AND_RIDER_CHECKBOX_LOCATOR = By.xpath(".//input[contains(@class,'mantine-Checkbox-input') and contains(@name,'ABCD')]");
    public static final By POPUP_CHECKBOX_LOCATOR = By.xpath("//label[contains(@class,'mantine-Checkbox-label')]");
    public static final By CONFIRM_BUTTON_LOCATOR = By.xpath("//span[contains(text(),'Confirm')]/parent::span/parent::button");
    public static final By OTHER_ADDON_LOCATOR = By.xpath("//span[contains(text(),'Other Add-ons')]/parent::div/ancestor::button");
    public static final By HEALTH_CASH_BENEFIT_LOCATOR = By.xpath("//input[contains(@class,'mantine-Checkbox-input') and contains(@name,'Hospital Cash Benefit')]/parent::div");
    public static final By SERIOUS_ILLNESSBOOSTER_LOCAOTR = By.xpath("//input[contains(@class,'mantine-Checkbox-input') and contains(@name,'Serious Illness Booster')]/parent::div");
    public static final By BASE_AND_TOTAL_PREMIUM_LOCATOR = By.xpath("//div[contains(@class,'premiumSummaryStack')]/div/div[contains(@class,'mantine-Group-root')]/span[2]");
    public static final By RECOMMANDED_AND_OTHER_ADDONS_LOCATOR = By.xpath("//div[contains(@class,'premiumSummaryStack')]/div/div[contains(@class,'mantine-Accordion-root')]/div/button/span[2]/div/span[2]");
    
    
    
    public void enterTheAge(int age) {
     enterText(YOUR_AGE_TEXTBOX_LOCATOR,age);
 
    }
    public void enterThePincode(int pincode) {
        enterText(PIN_CODE_LOCATOR,pincode);
     }
    
    public void clickOnLoyaltyDiscountAsNo() {
    	clickOn(NO_LOYALTY_DISCOUNT_LOCATOR);
    }
    
    public void enterTheInsuranceCoverAmount(int Amount) {
    	WebElement slider =	wait.until(ExpectedConditions.visibilityOfElementLocated(COVER_AMOUNT_SLIDER));
    	 int sliderWidth = slider.getSize().getWidth();
         int minValue = 1000000;   // ₹10 L (10 lakh)
         int maxValue = 20000000;  // ₹2 Cr (2 crore)
         int targetValue = Amount; // ₹50 L (50 lakh)

         // Calculate ratio of target value
         double valueRatio = (double)(targetValue - minValue) / (maxValue - minValue);

         // Calculate pixel offset
         int xOffset = (int)(sliderWidth * valueRatio);
         
         scrollTheSlider( COVER_AMOUNT_SLIDER, xOffset);
    }
    
    public void clickOnCalculatePremiumButton() {
    	clickOn(CALCULATE_PREMIUM_LOCATOR);
    }
    
    public void clickOnAddOnAndRiderCheckBox() {
       WebElement addOnAndRiderComponent = wait.until(ExpectedConditions.elementToBeClickable(ADDON_AND_RIDER_LOCATOR));
       WebElement checkbox = addOnAndRiderComponent.findElement(ADDON_AND_RIDER_CHECKBOX_LOCATOR);
       clickOn(checkbox);
       clickOn( POPUP_CHECKBOX_LOCATOR);
       clickOn(CONFIRM_BUTTON_LOCATOR);
    	
    }
    public void clickOnOtherRiderCheckBox() {
    	clickOn(OTHER_ADDON_LOCATOR);
    	clickOn(HEALTH_CASH_BENEFIT_LOCATOR);
    	clickOn(SERIOUS_ILLNESSBOOSTER_LOCAOTR);
    	
    }
    public List<WebElement> getBaseAndTotalPremiumAmount(){
    List<WebElement> baseAndTotalPremiumTexts = getAllElements(BASE_AND_TOTAL_PREMIUM_LOCATOR);
    return baseAndTotalPremiumTexts;
    }
    
   public List<WebElement> getRecommandedAndOtherAddOnsAmount(){
	List<WebElement> recomandedAndOtherAddonsTexts = getAllElements( RECOMMANDED_AND_OTHER_ADDONS_LOCATOR);
	 return recomandedAndOtherAddonsTexts;

    }
  
}
