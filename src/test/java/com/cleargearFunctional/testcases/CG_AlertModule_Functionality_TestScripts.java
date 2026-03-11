package com.cleargearFunctional.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.cleargear.screen.CG_AlertModule_Functionality;



@Listeners(ListnersNew.class)
public class CG_AlertModule_Functionality_TestScripts extends BaseTest {
   
	   private CG_AlertModule_Functionality_TestScripts() {}
	   
	
	@Test(priority = 1,description = "Verify the Login Functionality with valid credentials")
	
	public void verify_Login() {
		new CG_AlertModule_Functionality().Verify_SignIn();
	}
	
@Test(priority = 2,description = "Verify Active Alerts page opens from Clear Gear Main Menu")
	
	public void verify_CG_T65() {
		new CG_AlertModule_Functionality().CG_T65();
	}
	
	
}
