package com.cleargearFunctional.testcases;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cleargear.base.Base;
import com.cleargear.listeners.MyListeners;
import com.cleargear.pages.POM_ClearGear;
import com.cleargear.pages.POM_ClearGear_Alert;
import com.cleargear.pages.POM_ClearGear_Manager;
import com.cleargear.pages.POM_SignIn_Page;
@Listeners(MyListeners.class)
public class POM_ClearGear_Manager_TestClass extends Base {
	boolean value;
	@Test(priority = 2,description = "Verify functionality of Manager Menu on ClearGear page",enabled = true)
	public void VeriFy_Manager_Menu() throws InterruptedException {
	 value=	new POM_ClearGear_Manager(driver).verify_Manager_Page();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify the functionality of the Manager Menu")
		.isEqualTo(true);
		softly.assertAll();
		try {
			MyListeners.extentTest.pass("Manager button was clicked and successfully verified on the Manager page ");
		}
		catch (Exception e) {
			MyListeners.extentTest.pass("Manager button click action failed – Manager page did not load");
			// TODO: handle exception
		}
}
	
	
	@Test(priority = 1,description = "Verify_User_Can_Login_With_Valid_Username_And_Password ",enabled = true)
	public void VeriFy_Login() throws Throwable {
		new POM_SignIn_Page().Sign_inValidation();
	}
	@Test(priority = 3,description = "Verify_User_Can_navigate_to_Exceptionstab_Manager_Menu ",enabled = true)
	public void VeriFy_ExceptionTAB_Manager_Menu() throws Throwable {
		 value=	new POM_ClearGear_Manager(driver).verify_ExceptionTAB_Managerpage();
			SoftAssertions softly = new SoftAssertions();
			softly.assertThat(value)
			.as("Verify the functionality of the Exception TAB")
			.isEqualTo(true);
			softly.assertAll();
			try {
				MyListeners.extentTest.pass("Exception TAB Page successfully verified on the Manager page ");
			}	
			catch (Exception e) {
				MyListeners.extentTest.pass("Exceptions Tab verification failed – Manager page did not load");
				// TODO: handle exception
			}
	}
	
	
	
}