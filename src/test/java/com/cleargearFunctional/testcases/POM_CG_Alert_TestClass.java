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
public class POM_CG_Alert_TestClass extends Base {
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
			MyListeners.extentTest.pass("Alert Menu Succsessfully Navigate To Active Alert Page");
		}
		catch (Exception e) {
			MyListeners.extentTest.pass("Alert Menu not Succsessfully Navigate To Active Alert Page");
			// TODO: handle exception
		}
	}
	
	
	@Test(priority = 1,description = "Verify_User_Can_Login_With_Valid_Username_And_Password ",enabled = true)
	public void VeriFy_Login() throws Throwable {
		new POM_SignIn_Page().Sign_inValidation();
	}
	@Test(priority = 3,description = "Verify The Active module in Alert page",enabled =true)
	public void VeriFy_Activealerts_Alertpage() throws Throwable {
		value=new POM_ClearGear_Alert(driver).verify_alertspage_Activealerts();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Active alerts in alerts page")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Active Alerts page Succsessfully Verifed");
		}
		catch (Exception e) {
			MyListeners.extentTest.fail("Active Alerts page not Succsessfully Verifed");
			// TODO: handle exception
		}
	}
	
	}
