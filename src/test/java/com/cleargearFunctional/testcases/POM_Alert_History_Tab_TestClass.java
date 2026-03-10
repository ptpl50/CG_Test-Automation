package com.cleargearFunctional.testcases;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cleargear.base.Base;
import com.cleargear.listeners.MyListeners;
import com.cleargear.pages.POM_ClearGear;
import com.cleargear.pages.POM_ClearGear_Alert;
import com.cleargear.pages.POM_SignIn_Page;
@Listeners(MyListeners.class)
public class POM_Alert_History_Tab_TestClass extends Base {
	boolean value;
	@Test(priority = 2,description = "Verify The Navigation Of Alert Menu",enabled = true)
	public void VeriFy_AlertMenu() throws InterruptedException {
	 value=	new POM_ClearGear(driver).verify_NavigationOfAlertMenu();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Navigation Of Alert Menu")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Alert Menu Succsessfully Navigate To Actieve Alert Page");
		}
		catch (Exception e) {
			MyListeners.extentTest.pass("Alert Menu not Succsessfully Navigate To Actieve Alert Page");
			// TODO: handle exception
		}
	}
	
	
	@Test(priority = 1,description = "Verify_User_Can_Login_With_Valid_Username_And_Password ",enabled = true)
	public void VeriFy_Login() throws Throwable {
		new POM_SignIn_Page().Sign_inValidation();
	}
	@Test(priority = 3,description = "Verify user can navigate to history tab",enabled =true)
	public void VeriFy_HistoryTAB() throws Throwable {
		value=new POM_ClearGear_Alert(driver).Verify_User_Can_Navigate_To_History_Tab();
		
		value=new POM_ClearGear_Alert(driver).Verify_User_Can_Navigate_To_History_Tab();
		value=new POM_ClearGear_Alert(driver).Verify_History_Page_Loads_Successfully();		
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Navigation Of History TAB")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Successfully navigated to the History tab");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("Navigation to the History tab was unsuccessful");
			// TODO: handle exception
		}
	}
	@Test(priority = 4,description = "Verify Start and End Date field in history tab",enabled =true)
	public void VeriFy_StartDate_EndDate_Field() throws Throwable,InterruptedException {
		value=new POM_ClearGear_Alert(driver).verifyStartAndEndDateFields();
        		
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Start and End Date")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Start Date and End Date fields verified successfully");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("Start Date and End Date fields not verified successfully");
			// TODO: handle exception
		}
	}
	@Test(priority = 5,description = "Verify start date functionality by entering start date in history tab",enabled =true)
	public void Verify_by_Entering_StartDate_EndDate() throws Throwable {
		value=new POM_ClearGear_Alert(driver).enterStartDate("02/01/2026");
		value=new POM_ClearGear_Alert(driver).enterEndDate("03/01/2026");
		value=new POM_ClearGear_Alert(driver).clickSearchButton();
		//History.validateHistorySearchByDate("02/01/2026", "03/01/2026");
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Start Date Entry")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Start and End Date entered and validated successfully");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("Start and End Date input functionality is not working as expected");
			// TODO: handle exception
		}
	}}
