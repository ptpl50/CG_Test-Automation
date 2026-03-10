package com.cleargearFunctional.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.cleargear.base.Base;
import com.cleargear.listeners.MyListeners;
import com.cleargear.pages.POM_ClearGear;
import com.cleargear.pages.POM_MainMenu;
import com.cleargear.pages.POM_SignIn_Page;
@Listeners(MyListeners.class)
public class POM_Mainmenu_TestClass extends Base {
	@Test(priority = 2,description = "")
	public void VeriFy_MainmenuPage() throws Throwable {
		new POM_MainMenu(driver).verifyWelcome_User_Text();
	}
	
	
	@Test(priority = 1,description = "")
	public void VeriFy_Login() throws Throwable {
		new POM_SignIn_Page().Sign_inValidation();
	}
	@Test(priority = 3,description = "")
	public void VeriFy_Welcomeusertext() throws Throwable {
		new POM_MainMenu(driver).verifyWelcome_User_Text();
	}
	
	
	


}

