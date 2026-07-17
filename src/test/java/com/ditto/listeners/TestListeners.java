package com.ditto.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ditto.page.BasePage;
import com.ditto.utility.ExtentReportUtility;

public class TestListeners implements ITestListener {

	public void onTestStart(ITestResult result) {

		ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
		BasePage basePage = new BasePage();
		String screenshotPath = basePage.takeScreenshot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestSuccess(ITestResult result) {

		ExtentReportUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " " + "PASSED");
		BasePage basePage = new BasePage();
		String screenshotPath = basePage.takeScreenshot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	public void onTestFailure(ITestResult result) {
		BasePage basePage = new BasePage();
		String screenshotPath = basePage.takeScreenshot(result.getMethod().getMethodName());
		ExtentReportUtility.getTest().addScreenCaptureFromPath(screenshotPath);
		ExtentReportUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " " + "FAILED");
		ExtentReportUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

	}

	public void onTestSkipped(ITestResult result) {

		ExtentReportUtility.getTest().log(Status.SKIP,result.getMethod().getMethodName() + " " + "The Test has skipped");
	}

	public void onStart(ITestContext context) {

		ExtentReportUtility.setupSparkReporter("report.html");
	}

	public void onFinish(ITestContext context) {

		ExtentReportUtility.flushReport();
	}

}
