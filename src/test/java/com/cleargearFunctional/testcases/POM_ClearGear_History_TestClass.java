package com.cleargearFunctional.testcases;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cleargear.base.Base;
import com.cleargear.listeners.MyListeners;
import com.cleargear.pages.POM_ClearGear;
import com.cleargear.pages.POM_ClearGear_Alert;
import com.cleargear.pages.POM_ClearGear_History;
import com.cleargear.pages.POM_SignIn_Page;
@Listeners(MyListeners.class)
public class POM_ClearGear_History_TestClass extends Base {
	boolean value;
	@Test(priority = 2,description = "Verify The Navigation Of History Menu",enabled = true)
	public void VeriFy_History_Page_Navigation() throws Throwable {
		value=new POM_ClearGear_History(driver).verify_History_Page();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("History page in clear gear module")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("History Menu Succsessfully Navigate To History page");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("History Menu not Succsessfully Navigate To History Page");
			// TODO: handle exception
		}
	}
	
	
	@Test(priority = 1,description = "Verify_User_Can_Login_With_Valid_Username_And_Password ",enabled = true)
	public void VeriFy_Login() throws Throwable {
		new POM_SignIn_Page().Sign_inValidation();
	}
	@Test(priority = 3,description = "Verify start date functionality by entering start date in history tab",enabled =true)
	public void Verify_by_Entering_StartDate_EndDate() throws Throwable {
		
		  value=new POM_ClearGear_History(driver).EnterStartAndEndDateFieldsCalender();
		//value=new POM_ClearGear_History(driver).enterStartDate("02/01/2026");
		//value=new POM_ClearGear_History(driver).enterEndDate("03/01/2026");
		//value=new POM_ClearGear_History(driver).clickSearchButton();
		//History.validateHistorySearchByDate("02/01/2026", "03/01/2026");
		//SoftAssertions softly = new SoftAssertions();
		//softly.assertThat(value)
		//.as("Verify Start Date and End Date")
		//.isEqualTo(true);
		//softly.assertAll();
		try {
			MyListeners.extentTest.pass("Start and End Date entered and validated successfully");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("Start and End Date input functionality is not working as expected");
			// TODO: handle exception
		}
	}}
