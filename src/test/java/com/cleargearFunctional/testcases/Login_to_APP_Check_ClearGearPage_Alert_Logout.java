package com.cleargearFunctional.testcases;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cleargear.base.Base;

public class Login_to_APP_Check_ClearGearPage_Alert_Logout extends Base
{
	// ================= Login & Navigate =================

	@Test
	public void loginAndNavigateToAlertModule_Verification() throws Throwable
	{
		
		signin.Sign_inValidation();
        Reporter.log("Clear Gear Menu Verification Started .....");
        mainMenu.clickClear_Gear_Button();
		clearGear.clickAlerts();
		alertModule.verifyAlertModules();
		 mainMenu.clickLogout();
		Reporter.log("Logout Validation Done .....");
	}

	// ================= Active Module =================

	@Test
	public void activeModule_FunctionalValidation() throws Throwable
	{
		System.out.println("Login validation started .....");
		signin.Sign_inValidation();
        Reporter.log("Clear Gear Menu Verification Started .....");
        mainMenu.clickClear_Gear_Button();
    	clearGear.clickAlerts();
		alertModule.clickActiveModule();
		mainMenu.clickLogout();
		Reporter.log("Logout Validation Done .....");
	}

	// ================= History Module =================

	@Test
	public void historyModule_FunctionalValidation() throws Throwable
	{
		System.out.println("Login validation started .....");
		signin.Sign_inValidation();
        Reporter.log("Clear Gear Menu Verification Started .....");
        mainMenu.clickClear_Gear_Button();
    	clearGear.clickAlerts();
    	alertModule.clickHistoryModule();
		mainMenu.clickLogout();
		Reporter.log("Logout Validation Done .....");
		
	}

	// ================= Statistics Module =================

	@Test
	public void statisticsModule_FunctionalValidation() throws Throwable
	{
		System.out.println("Login validation started .....");
		signin.Sign_inValidation();
        Reporter.log("Clear Gear Menu Verification Started .....");
        mainMenu.clickClear_Gear_Button();
    	clearGear.clickAlerts();
    	alertModule.clickStatisticsModule();
		mainMenu.clickLogout();
		Reporter.log("Logout Validation Done .....");
	}

}



