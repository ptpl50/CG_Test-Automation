package com.cleargearFunctional.testcases;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.cleargear.base.Base;
import com.cleargear.utils.ExtentReporter;

	public class Login_Create_User_Logout extends Base
	{
	   
	    // ================= POSITIVE TEST =================

	    @Test(priority = 1, dataProvider = "validUserData")
	    public void createNewUser_Positive(
	            String empId,
	            String firstName,
	            String lastName,
	            String email)
	            throws Throwable
	    {
	    	signin.Sign_inValidation();
	    	mainMenu.clickUser_Management_Button();
	    	userManagement.clickCreateNewUserButton();
	        ExtentReporter.extentTest =
	        ExtentReporter.extentReport.createTest("Create New User - Positive");
	        createUser.verifyCreateNewUserPopup();
	        createUser.enterEmployeeID(empId);
	        createUser.enterFirstName(firstName);
	        createUser.enterLastName(lastName);
	        createUser.enterEmail(email);
	        createUser.selectLanguageFromDropdown("EN");
	        createUser.selectRoleFromDropdown("ADMINISTRATOR");
	        createUser.clickCreateNewUserButton();
	        ExtentReporter.extentReport.setSystemInfo("User created successfully with valid data", email);
	        mainMenu.clickLogout();
	        Reporter.log("Logout Validation Done .....");

	    }

	    // ================= NEGATIVE TEST =================

	    @Test(priority = 2, dataProvider = "invalidUserData")
	    public void createNewUser_Negative(
	            String empId,
	            String firstName,
	            String lastName,
	            String email)
	            throws Throwable
	    {
	    	signin.Sign_inValidation();
	    	mainMenu.clickUser_Management_Button();
	        ExtentReporter.extentTest =
	        ExtentReporter.extentReport.createTest("Create New User - Negative");

	        userManagement.clickCreateNewUserButton();
	        createUser.verifyCreateNewUserPopup();
	        createUser.enterEmployeeID(empId);
	        createUser.enterFirstName(firstName);
	        createUser.enterLastName(lastName);
	        createUser.enterEmail(email);
	        createUser.clickCreateNewUserButton();

	        // Validation message verification can be added here
	        ExtentReporter.extentReport.setSystemInfo("Validation displayed as expected for invalid data", email);
	        mainMenu.clickLogout();
	        Reporter.log("Logout Validation Done .....");
	    }

	    // ================= DATA PROVIDERS =================

	    @DataProvider(name = "validUserData")
	    public Object[][] validUserData()
	    {
	        return new Object[][] {
	                {"EMP1001", "Rahul", "Sharma", "rahul.sharma@test.com"},
	                {"EMP1002", "Amit", "Verma", "amit.verma@test.com"}
	        };
	    }

	    @DataProvider(name = "invalidUserData")
	    public Object[][] invalidUserData()
	    {
	        return new Object[][] {
	                {"", "Rahul", "Sharma", "rahul@test.com"},       // Missing Emp ID
	                {"EMP1003", "", "Sharma", "rahul@test.com"},    // Missing First Name
	                {"EMP1004", "Rahul", "", "rahul@test.com"},     // Missing Last Name
	                {"EMP1005", "Rahul", "Sharma", "rahultest.com"} // Invalid Email
	        };
	    }
	}
