package com.cleargear.screen;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cleargear.commonfunction.CommonFunction;
import com.cleargear.driver.DriverManagerNew;
import com.cleargear.utils.ExtentreportTestManager;
import com.cleargear.utils.PopertyUtils;

public class CG_AlertModule_Functionality extends CommonFunction {
	
	String result;
	boolean value;
	private WebDriver driver;
	
	@FindBy(xpath = "//button[.='Sign In']")
	private WebElement signIn;
	@FindBy(xpath = "//button[contains(@id,'trigger-username')]" )
	private WebElement UsernameTab;
	@FindBy(xpath = "//input[@placeholder='Username']")
	private WebElement Username_Text_Field;
	@FindBy(xpath = "//input[@placeholder='Password']")
	private WebElement Password_Text_Field;
	@FindBy(xpath = "//h1[.='Main Menu']")
	private WebElement mainMenu;
	
	@FindBy(xpath = "//div[@aria-label='Navigate to Clear Gear']")
	private WebElement clearGearMenu;
	@FindBy(xpath = "//div[@aria-label='Navigate to Alerts']")
	private WebElement alertMenu;
	@FindBy(xpath = "(//span[.='Connected'])[1]")
	private WebElement connected;
	@FindBy(xpath = "(//span[.='ACTIVE ALERTS'])[1]")
	private WebElement activeAlertPage;
	
	
	
	
	
	
	public CG_AlertModule_Functionality() {
		this.driver = DriverManagerNew.getDriver();

	    PageFactory.initElements(driver, this);	
	}
	
	
	public void Verify_SignIn() {
		waitForVisible(Username_Text_Field);
		scrollToElement(signIn, "Sign In Button");
		sendKeys(Username_Text_Field, PopertyUtils.get("username"), "User Name");
		sendKeys(Password_Text_Field, PopertyUtils.get("password"), "Password");
		click(signIn, "Sign In");
		waitForVisible(mainMenu);
		highlightElement(mainMenu, "Main Menu Header");
		value=mainMenu.isDisplayed();
		try {
			SoftAssertions softly = new SoftAssertions();

			softly.assertThat(value)
			      .as("Verify that Login is successful")
			      .isTrue();
			softly.assertAll();
			ExtentreportTestManager.getExtentTest().pass("User succsessfully Sign In Into The Application");
			
			
		} catch (Exception e) {
			ExtentreportTestManager.getExtentTest().pass("User not succsessfully Sign In Into The Application");
			// TODO: handle exception
		}
		
	}
	
	
	public void CG_T65() {
		waitForVisible(clearGearMenu);
		click(clearGearMenu, "Clear Gear Menu");
		waitForVisible(alertMenu);
		click(alertMenu, "Alert Menu");
		waitForVisible(connected);
		waitForVisible(activeAlertPage);
		highlightElement(activeAlertPage, "Active Alert");
		value=activeAlertPage.isDisplayed();
		try {
			SoftAssertions softly = new SoftAssertions();

			softly.assertThat(value)
			      .as("To ensure user can navigate to Active Alerts page.")
			      .isTrue();
			softly.assertAll();
			ExtentreportTestManager.getExtentTest().pass("Active Alerts page  open successfully.");
			
			
		} catch (Exception e) {
			ExtentreportTestManager.getExtentTest().pass("Active Alerts page not open successfully.");
			// TODO: handle exception
		}
		
		
	}
	
	
	
	
	

}
