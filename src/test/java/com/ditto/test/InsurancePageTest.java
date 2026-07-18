package com.ditto.test;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.ditto.page.AddFamilyMemberPage;
import com.ditto.page.CalculatePremiumPage;
import com.ditto.page.InsurancePage;
import com.ditto.page.PolicyDetailsPage;
import com.ditto.utility.ExtentReportUtility;

public class InsurancePageTest extends BaseTest {
	InsurancePage insurancePage;
	PolicyDetailsPage policyDetailsPage;
	AddFamilyMemberPage addfamilyMemberPage;
	CalculatePremiumPage calculatePremiumPage;
	List<WebElement> baseAndTotalPremiumTexts;
	List<WebElement> recomandedAndOtherAddonsTexts;
	
	@BeforeMethod
	public void helperPage() {
	 insurancePage = new InsurancePage();
	 policyDetailsPage = new PolicyDetailsPage();
	 addfamilyMemberPage = new AddFamilyMemberPage();
	 calculatePremiumPage = new CalculatePremiumPage();
	}
	
	@Test(description="TC-01 : verify Total Premium Is Sum Of Addons And Base Premium",enabled=true)
	public void verifyTotalPremiumIsSumOfAddonsAndBasePremium() {
		insurancePage.clcikOnOptimaSecureHealthInsurance();
		ExtentReportUtility.getTest().log(Status.INFO, "user select the Optima Secure + health insurance policy");
		policyDetailsPage.clickOnMainBenefitNextButton();
		policyDetailsPage.clickOnWaitingPeriodNextButton();
		policyDetailsPage.clickOnWhatNotCoverNextButton();
		policyDetailsPage.clickOnExtraBenefitContinueButton();
		ExtentReportUtility.getTest().log(Status.INFO, "user read all policy details");
		addfamilyMemberPage.selectTheSelfMaleMember();
		addfamilyMemberPage.clickOnNextStepButton();
		ExtentReportUtility.getTest().log(Status.INFO, "user added family member and click on next");
		calculatePremiumPage.enterTheAge(30);
		calculatePremiumPage.enterThePincode(441912);
		calculatePremiumPage.clickOnLoyaltyDiscountAsNo();
		calculatePremiumPage.enterTheInsuranceCoverAmount(2500000);
		ExtentReportUtility.getTest().log(Status.INFO, "user enter his age,pincode,and insurance cover amount");
		calculatePremiumPage.clickOnCalculatePremiumButton();
		ExtentReportUtility.getTest().log(Status.INFO, "And click on calculate premium amount");
		calculatePremiumPage.clickOnAddOnAndRiderCheckBox();
		calculatePremiumPage.clickOnOtherRiderCheckBox();
		ExtentReportUtility.getTest().log(Status.INFO, "user select add-on and other rider checkbox");
	    baseAndTotalPremiumTexts =  calculatePremiumPage.getBaseAndTotalPremiumAmount();
		recomandedAndOtherAddonsTexts = calculatePremiumPage.getRecommandedAndOtherAddOnsAmount();
		 
		double basePremium = Double.parseDouble(baseAndTotalPremiumTexts.get(0).getText().replaceAll("[₹,]", ""));
		double totalPremium =   Double.parseDouble(baseAndTotalPremiumTexts.get(1).getText().replaceAll("[₹,]", ""));
		ExtentReportUtility.getTest().log(Status.INFO, "user get base premium "+basePremium+" and total premium "+basePremium+" amount");  
		
	    double recommendedAddons =  Double.parseDouble( recomandedAndOtherAddonsTexts.get(0).getText().replaceAll("[₹,]", ""));
		double otherAddons =   Double.parseDouble( recomandedAndOtherAddonsTexts.get(1).getText().replaceAll("[₹,]", ""));
		ExtentReportUtility.getTest().log(Status.INFO, "user get recommended add ons "+recommendedAddons+" and other addons "+otherAddons+" amount");  
		
		double expectedTotalPremium = basePremium+recommendedAddons+otherAddons;
		ExtentReportUtility.getTest().log(Status.INFO, "user get expected total premium "+expectedTotalPremium+" amount"); 
		 
		Assert.assertEquals( totalPremium, expectedTotalPremium, "something is missing.. total premium "+totalPremium+" does not match with expeced total premium "+expectedTotalPremium+"");
		 ExtentReportUtility.getTest().log(Status.PASS, "total premium "+totalPremium+" with expeced total premium "+expectedTotalPremium+"");  
	}

}
