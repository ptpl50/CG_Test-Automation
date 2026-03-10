package com.cleargearFunctional.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.cleargear.base.Base;

public class Login_to_App_Verify_History_Module_In_Alert extends Base
{
	@Test
	public void Verify_History_Module_In_Alert() throws Throwable
	{
		signin.Sign_inValidation();
		Reporter.log("Clear Gear Menu Verification Started .....");
		mainMenu.clickClear_Gear_Button();
		clearGear.clickHistory();
		History.verifyStartAndEndDateFields();
		History.validateHistorySearchByDate("02/01/2026", "03/01/2026");
		mainMenu.clickLogout();
		Reporter.log("Logout Validation Done .....");
	}


}
