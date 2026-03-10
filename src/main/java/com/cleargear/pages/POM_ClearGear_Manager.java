package com.cleargear.pages;

import java.time.Duration;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cleargear.base.Base;
import com.cleargear.driver.DriverManager;
import com.cleargear.listeners.MyListeners;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Helper;

public class POM_ClearGear_Manager extends Base{
	public JavascriptExecutor js;
	
	String result;
	boolean value;
	WebDriver driver;
//	ExtentReports extent;
//	ExtentTest test;
	
	@FindBy(xpath = "//span[text()='EXCEPTIONS'][1]")
	private WebElement Managerpage;
	
	@FindBy(xpath = "//span[normalize-space()='Manager']/..")
	private WebElement Manager_Menu;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div/div/div[3]/div/img")
	private WebElement Clear_Gear_Button;
	
	@FindBy(xpath = "//span[text()='EXCEPTIONS'][1]")
	private WebElement Managerpage_Exceptions;
	
	@FindBy(xpath = "(//label[normalize-space()='Select Sorter'])[1]")
	private WebElement Select_Sorter;
	
	@FindBy(xpath = "(//select[option[normalize-space()='Main Sorter Unit 1']])[1]")
	private WebElement Dropdown;
	
	@FindBy(xpath = "(//span[normalize-space()='Exception'])[1]")
	private WebElement Exception_Column;
	
	@FindBy(xpath = "(//span[normalize-space()='Divert Lane'])[1]")
	private WebElement Divert_Lane_Column;
	
	@FindBy(xpath = "(//span[normalize-space()='Lane Reassignment'])[1]")
	private WebElement Lane_Reassignment_Column;
	
	@FindBy(xpath = "(//span[normalize-space()='Actions'])[1]")
	private WebElement Actions_Coloumn;
	
	
	
	
	
	
	
	 ExtentReports extent;
     ExtentTest extentTest;

	 private WebDriverWait wait;
	 
		public POM_ClearGear_Manager(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	 
	
	
		public boolean verify_Manager_Page() throws InterruptedException {
			Clear_Gear_Button.click();
			MyListeners.extentTest.info("Click on Clear Gear button");
			Thread.sleep(3000);
			Manager_Menu.click();
			MyListeners.extentTest.info("Manager_Menu Button Clicked");
			Thread.sleep(5000);
			value=Managerpage.isDisplayed();
			return value;
			
		}
	
	
	public boolean verify_ExceptionTAB_Managerpage() throws Throwable {
		Thread.sleep(3000);
		value=Managerpage_Exceptions.isDisplayed();
		Helper.highlightElement(driver, Managerpage_Exceptions);
		MyListeners.extentTest.info("Exceptions field is displayed");
		Thread.sleep(3000);
		value=Select_Sorter.isDisplayed();
		Helper.highlightElement(driver, Select_Sorter);
		MyListeners.extentTest.info("Select Sorter is displayed");
		Thread.sleep(5000);
		value=Dropdown.isDisplayed();
		Helper.highlightElement(driver, Dropdown);
		MyListeners.extentTest.info("Dropdown is displayed");
		Thread.sleep(5000);
		value=Exception_Column.isDisplayed();
		Helper.highlightElement(driver, Exception_Column);
		MyListeners.extentTest.info("Exception Column is displayed");
		Thread.sleep(5000);
		value=Divert_Lane_Column.isDisplayed();
		Helper.highlightElement(driver, Divert_Lane_Column);		
		MyListeners.extentTest.info("Divert_Lane_Column is displayed");
		Thread.sleep(5000);
		value=Lane_Reassignment_Column.isDisplayed();
		Helper.highlightElement(driver, Lane_Reassignment_Column);
		MyListeners.extentTest.info("Lane_Reassignment_Column is displayed");
		Thread.sleep(5000);
		value=Actions_Coloumn.isDisplayed();
		Helper.highlightElement(driver, Actions_Coloumn);
		MyListeners.extentTest.info("Actions_Coloumn is displayed");
		Thread.sleep(5000);	
				
		return value;
		
		
	}
}