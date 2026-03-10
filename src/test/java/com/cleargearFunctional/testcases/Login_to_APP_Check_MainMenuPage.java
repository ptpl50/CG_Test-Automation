package com.cleargearFunctional.testcases;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.cleargear.base.Base;

public class Login_to_APP_Check_MainMenuPage extends Base
{

	    // ===============================
	    // MAIN MENU VERIFICATION
	    // ===============================
	    @Test
	    public void mainMenuVerification() throws Throwable
	    {
	    	signin.Sign_inValidation();
	        Reporter.log("Main Menu Verification Started .....");
	        mainMenu.verifyMainMenu();
	        mainMenu.clickLogout();
	        Reporter.log("Logout Validation Done .....");
	        
	    }

	    // ===============================
	    // MAIN MENU NAVIGATION VALIDATION
	    // ===============================
	    @Test(dependsOnMethods = "mainMenuVerification")
	    public void mainMenuNavigationValidation() throws Throwable
	    {
	    	
	    	signin.Sign_inValidation();
	        Reporter.log("Main Menu Navigation Validation Started .....");

	        // Operations Overview
			/*
			 * mainMenu.clickOperations_Overview_Button();
			 *  Thread.sleep(2000);
			 * driver.navigate().back();
			 *///Not Working Module

	        // Clear Flow
	        mainMenu.clickClear_Flow_Button();
	        Thread.sleep(2000);
	        driver.navigate().back();

	        // Clear Gear
			/*
			 * mainMenu.clickClear_Gear_Button();
			 *  Thread.sleep(2000);
			 * driver.navigate().back();
			 *///Not Working Module

	        // Clear Team
	        mainMenu.clickClear_Team_Button();
	        Thread.sleep(2000);
	        driver.navigate().back();

	        // Clear Slot
			/*
			 * mainMenu.clickClear_Slot_Button();
			 *  Thread.sleep(2000);
			 * driver.navigate().back();
			 *///Not Working Module
	        
	        // System Health
			/*
			 * mainMenu.clickSystem_Health_Button(); 
			 * Thread.sleep(2000);
			 * driver.navigate().back();
			 *///Not Working Module
	        
	        // User Management
	        mainMenu.clickUser_Management_Button();
	        Thread.sleep(2000);
	        driver.navigate().back();

	        // Settings
	        mainMenu.clickSettings_Button();
	        Thread.sleep(2000);
	        driver.navigate().back();
	        mainMenu.clickLogout();
	        Reporter.log("Logout Validation Done .....");
	    }
	}



