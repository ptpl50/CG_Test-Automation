package com.cleargear.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cleargear.base.Base;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Helper;

public class POM_MainMenu extends Base{
	
	String result;
	boolean value;
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;
	
	@FindBy(xpath = "//span[contains(@class,'font-medium')] | //span[contains(.,'Welcome')]")
	private WebElement Welcome_User_Text;
	
	@FindBy(xpath = "(//h1[normalize-space()='Main Menu'])")
	private WebElement Verify_Mainmenu_Text;
	
	

	@FindBy(xpath = "//button[normalize-space()='Logout']")
	private WebElement Logout_Button;

	@FindBy(xpath = "//body/div/div/main/div/div/div/div[1] | //span[contains(.,'Operations Overview')]/..")
	private WebElement Operations_Overview_Button;

	@FindBy(xpath = "//body//div//div//div[2] | //span[contains(.,'Clear Flow')]/..")
	private WebElement Clear_Flow_Button;

	//@FindBy(xpath = "//body//div//div//div[3] | //span[contains(.,'Clear Gear')]/..")
	@FindBy(xpath = "//div[contains(@class,'w-fit grid gap-x-12 gap-y-8 place-items-center')]/div[contains(@class,'w-fit md:w-[192px] sm:bg-white flex flex-col items-center justify-center space-y-4 rounded-xl')][3]")
	private WebElement Clear_Gear_Button;

	@FindBy(xpath = "//body//div//div//div[4] | //span[contains(.,'Clear Team')]/..")
	private WebElement Clear_Team_Button;

	@FindBy(xpath = "//body//div//div//div[5] | //span[contains(.,'Clear Slot')]/..")
	private WebElement Clear_Slot_Button;

	@FindBy(xpath = "//body//div//div//div[6] | //span[contains(.,'System Health')]/..")
	private WebElement System_Health_Button;

	@FindBy(xpath = "//body//div//div//div[7] | //span[contains(.,'User Management')]/..")
	private WebElement User_Management_Button;

	@FindBy(xpath = "//body//div//div//div[8] | //span[contains(.,'Settings')]/..")
	private WebElement Settings_Button;

	
	
	
	
	
	
	
	public POM_MainMenu(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void verifyWelcome_User_Text() throws Throwable ,InterruptedException {
		
		Helper.highlightElement(driver, Welcome_User_Text);
	    Rectangle rect = Welcome_User_Text.getRect();
	    
	    value=Welcome_User_Text.isDisplayed();
		SoftAssertions softly = new SoftAssertions();
		softly.assertThat(value)
		.as("Verify Of Welcome user text")
		.isEqualTo(true);
		softly.assertAll();
		try {
		    test.pass("Welcome user text verify Sucessfully");
		}
		catch (Exception e) {
			test.pass("Welcome user text not verify Succsessfully ");
			// TODO: handle exception
		}
	}
	
		public void verifyMenu_Button(WebElement element) throws Throwable {
			
			Helper.highlightElement(driver, element);
			Rectangle rect = element.getRect();
			 value=Verify_Mainmenu_Text.isDisplayed();
			SoftAssertions softly = new SoftAssertions();
			softly.assertThat(value)
			.as("Verify Of Navigation Of Search_Menu")
			.isEqualTo(true);
			softly.assertAll();
			try {
			    test.pass("Search_Menu Succsessfully Navigate To Scan History Page");
			}
			catch (Exception e) {
				test.pass("Search_Menu not Succsessfully Navigate To Scan History Page");
				// TODO: handle exception
			}
	}
		
	}