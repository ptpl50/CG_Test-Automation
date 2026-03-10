package com.cleargearFunctional.testcases;
	import org.openqa.selenium.JavascriptExecutor;
import org.testng.Reporter;
	import org.testng.annotations.Test;
	import com.cleargear.base.Base;
	import com.cleargear.utils.ExtentReporter;
	public class Login_to_APP_Check_ClearGearPage extends Base
	{
	    // ===============================
	    // CLEAR GEAR MENU VERIFICATION
	    // ===============================
//	    @Test
//	    public void clearGearMenuVerification() throws Throwable
//	    {
//	        signin.Sign_inValidation();
//	        Reporter.log("Clear Gear Menu Verification Started .....");
//
//	        mainMenu.clickClear_Gear_Button();
//
//	        ExtentReporter.extentTest =
//	                ExtentReporter.extentReport.createTest("Clear Gear - Menu Verification");
//
//	        clearGear.verifyClearGearMenu();
//	        
//	        Reporter.log("Logout Validation Done .....");
//	        mainMenu.clickLogout();
//	    }

	    // ===============================
	    // CLEAR GEAR MENU NAVIGATION
	    // ===============================
	    @Test
	    public void clearGearMenuNavigationValidation() throws Throwable
	    {
	        signin.Sign_inValidation();
	        mainMenu.clickClear_Gear_Button();

	        Reporter.log("Clear Gear Menu Navigation Validation Started .....");

	        ExtentReporter.extentTest =
	                ExtentReporter.extentReport.createTest("Clear Gear - Menu Navigation");

	        // Alerts
	        clearGear.clickAlerts();
	        Reporter.log("Alert Clicked");
	        Thread.sleep(2000);
	        driver.navigate().back();
	        mainMenu.clickClear_Gear_Button();
	        // Manager
	        clearGear.clickManager();
	        Thread.sleep(2000);
	        driver.navigate().back();
	        mainMenu.clickClear_Gear_Button();

	         //History
            clearGear.clickHistory();
            Thread.sleep(5000);
            clearGear.backhistory();
            driver.navigate().back();
            mainMenu.clickClear_Gear_Button();
	        
	         //Maintenance
	        clearGear.clickMaintenance();
	        Thread.sleep(2000);
	        driver.navigate().back();
	        mainMenu.clickClear_Gear_Button();
	        // Search
	        clearGear.clickSearch();
	        Thread.sleep(2000);
	        driver.navigate().back();
	        
	        Reporter.log("Logout Validation Started .....");
	        mainMenu.clickLogout();
	    }

	}
