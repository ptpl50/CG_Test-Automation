package com.cleargearFunctional.testcases;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cleargear.base.Base;
import com.cleargear.listeners.MyListeners;
import com.cleargear.pages.POM_ClearGear;
import com.cleargear.pages.POM_SignIn_Page;
@Listeners(MyListeners.class)
public class POM_ClearGear_TestClass extends Base {
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
	@Test(priority = 3,description = "Verify The Navigation Of Manager Menu",enabled =true)
	public void VeriFy_ManagerMenu() throws Throwable {
		value=new POM_ClearGear(driver).verify_NavigationOfManagerMenu();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Navigation Of Manager Menu")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Manager Menu Succsessfully Navigate To Exceptions Page");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("Manager Menu not Succsessfully Navigate To Exceptions Page");
			// TODO: handle exception
		}
	}
	@Test(priority = 4,description = "Verify The Navigation Of History Menu",enabled = true)
	public void VeriFy_HistoryMenu() throws Throwable {
		value=new POM_ClearGear(driver).verify_NavigationOfHistoryMenu();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Navigation Of History Menu")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("History Menu Succsessfully Navigate To Event Page");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("History Menu not Succsessfully Navigate To Event Page");
			// TODO: handle exception
		}
	}
	@Test(priority = 5,description = "Verify The Navigation Of Maintenance Menu",enabled =true)
	public void VeriFy_MaintenanceMenu() throws Throwable {
		value=new POM_ClearGear(driver).verify_NavigationOfMaintenanceMenu();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Navigation Of Maintenance_Menu")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Maintenance_Menu Succsessfully Navigate To Maintenance Log Page");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("Maintenance_Menu not Succsessfully Navigate To Maintenance Log Page");
			// TODO: handle exception
		}
	}
	@Test(priority = 6,description = "Verify The Navigation Of Search Menu",enabled = true)
	public void VeriFy_SearchMenu() throws Throwable {
		value=new POM_ClearGear(driver).verify_NavigationOfSearchMenu();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Navigation Of Search_Menu")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Search_Menu Succsessfully Navigate To Scan History Page");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("Search_Menu not Succsessfully Navigate To Scan History Page");
			// TODO: handle exception
		}
	}
	
	
	
	
	

}
