package com.cleargearFunctional.testcases;

	import org.testng.Reporter;
	import org.testng.annotations.Test;
	import org.testng.asserts.SoftAssert;

	import com.cleargear.base.Base;

	public class Login_to_APP_Check_Usermanagement extends Base
	{
		// ===============================
		// USER MANAGEMENT PAGE VERIFICATION
		// ===============================
		@Test
		public void userManagementPageVerification() throws Throwable
		{
			SoftAssert softAssert = new SoftAssert();

			signin.Sign_inValidation();
			mainMenu.clickUser_Management_Button();
			Reporter.log("User Management Page Verification done.....");
			userManagement.verifyUserManagementPage();
			userManagement.verifyCreateNewUserTableData();
			softAssert.assertAll();
			Reporter.log("User Management Page Verification Done .....");
			Reporter.log("Logout Validation Started .....");
			mainMenu.clickLogout();
			Reporter.log("Logout Validation Done .....");
		}

		// ===============================
		// CREATE NEW USER POPUP VALIDATION
		// ===============================
		@Test(dependsOnMethods = "userManagementPageVerification")
		public void createNewUserPopupValidation() throws Throwable
		{
			signin.Sign_inValidation();
		    mainMenu.clickUser_Management_Button();
			Reporter.log("User Management Page Verification Done .....");
			userManagement.clickCreateNewUserButton();
			userManagement.closeCreateNewUserPopup();
			Reporter.log("createNewUserPopupValidation Done .....");
			Reporter.log("Logout Validation Done .....");
			mainMenu.clickLogout();
		}

	}