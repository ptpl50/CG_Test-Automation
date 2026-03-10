package com.cleargearFunctional.testcases;
import org.testng.annotations.Test;

import com.cleargear.base.Base;

public class LoginAndLogOut extends Base
{
	@Test
	public void loginandOutverification() throws Throwable
	{
		System.out.println("Login verification started .....");
		signin.Sign_inVerification();

	}
	
	@Test(dependsOnMethods = "loginandOutverification")
	public void loginandOutvalidation() throws Throwable
	{
		System.out.println("Login validation started .....");
		signin.Sign_inValidation();
	}
}