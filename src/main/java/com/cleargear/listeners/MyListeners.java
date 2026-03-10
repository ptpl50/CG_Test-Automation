package com.cleargear.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.cleargear.driver.DriverManager;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Utilities;

public class MyListeners implements ITestListener {

	public ExtentReports extentReport;
	public static  ExtentTest extentTest;

	@Override
	public void onStart(ITestContext context) {

		extentReport = ExtentReporter.generateExtentReport();

	}

	@Override
	public void onTestStart(ITestResult result) {
		 String testName = result.getMethod().getMethodName();
		    String description = result.getMethod().getDescription();

		    extentTest = extentReport.createTest(testName, description);

		   // extentTest.info(testName + " execution started");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		WebDriver driver=DriverManager.getDriver();
		if(driver!=null)
		{
			String destinationScreenshotPath = Utilities.captureScreenshot(driver);
			extentTest.pass("",MediaEntityBuilder.createScreenCaptureFromBase64String(destinationScreenshotPath).build());
			//extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		}
		//extentTest.log(Status.INFO,result.getThrowable());;
		extentTest.log(Status.PASS,result.getName()+" got success");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		WebDriver driver=DriverManager.getDriver();
		if(driver!=null)
		{
			String destinationScreenshotPath = Utilities.captureScreenshot(driver);
			extentTest.fail("",MediaEntityBuilder.createScreenCaptureFromBase64String(destinationScreenshotPath).build());
			//extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
		}
		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.FAIL,result.getName()+" got failed");
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		extentTest.log(Status.INFO,result.getThrowable());
		extentTest.log(Status.SKIP, result.getName()+" got skipped");

	}

	@Override
	public void onFinish(ITestContext context) {

		extentReport.flush();

		String pathOfExtentReport = System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html";
		File extentReport = new File(pathOfExtentReport);

		try
		{
			Desktop.getDesktop().browse(extentReport.toURI());
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}