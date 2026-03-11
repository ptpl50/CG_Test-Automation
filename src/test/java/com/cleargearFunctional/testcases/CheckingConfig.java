package com.cleargearFunctional.testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ListnersNew.class)
public class CheckingConfig extends BaseTest{
	@Test(priority = 1,description = "Everything working fine")
	public void check() throws InterruptedException {
		System.out.println("Working fine");
		Thread.sleep(60000);
	}

}
