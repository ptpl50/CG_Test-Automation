package com.cleargear.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.cleargear.base.Base;
import com.cleargear.listeners.MyListeners;
import com.cleargear.utils.ExtentReporter;

public class POM_ClearGear extends Base{
	
	String result;
	boolean value;
	WebDriver driver;
//	ExtentReports extent;
//	ExtentTest test;
	
	@FindBy(xpath = "//div[@aria-label='Navigate to Alerts'] | //span[.='Alerts']/..")
	private WebElement Alerts_Menu;
	@FindBy(xpath = "//span[normalize-space()='Manager']/..")
	private WebElement Manager_Menu;
	@FindBy(xpath = "//span[normalize-space()='History']/..")
	private WebElement History_Menu;
	@FindBy(xpath = "//div[text()='Back to the menu']")
	private WebElement History_back;
	//@FindBy(xpath = "//span[normalize-space()='Maintenance']/..")
	@FindBy(xpath = "//div[@aria-label='Navigate to Maintenance']")
	private WebElement Maintenance_Menu;
	@FindBy(xpath = "//span[normalize-space()='Search']/..")
	private WebElement Search_Menu;
	@FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div/div/div[3]/div/img")
	private WebElement Clear_Gear_Button;
	//@FindBy(xpath = "(//span[.='ACTIVE ALERTS'])[1]")
	//private WebElement alertPage;
	@FindBy(xpath = "(//span[text()='ACTIVE ALERTS'])[1]")
	private WebElement Alertpage;
	@FindBy(xpath = "//span[text()='EXCEPTIONS'][1]")
	private WebElement Managerpage;
	@FindBy(xpath = "(//span[normalize-space()='Event History'])[1]")
	private WebElement Historypage;
	@FindBy(xpath = "(//span[normalize-space()='Maintenance Log'])[1]")
	private WebElement Maintenancepage;
	@FindBy(xpath = "(//span[normalize-space()='SCAN HISTORY'])[1]")
	private WebElement Searchpage;
	
	
	
	
	 ExtentReports extent;
     ExtentTest extentTest;
	
	
	
	public POM_ClearGear(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verify_NavigationOfAlertMenu() throws InterruptedException {
		Thread.sleep(3000);
		Clear_Gear_Button.click();
		MyListeners.extentTest.info("Click on Clear Gear button");
		Thread.sleep(3000);
		Alerts_Menu.click();
		MyListeners.extentTest.info("Alerts menu clicked successfully");
		Thread.sleep(5000);
		value=Alertpage.isDisplayed();
		MyListeners.extentTest.info("Alerts page opened and displayed successfully");
		
		return value;
		
		
	}
	public boolean verify_ClickonAlertMenu() throws InterruptedException {
		
		Alerts_Menu.click();
		MyListeners.extentTest.info("Alerts menu clicked successfully");
		Thread.sleep(5000);
		value=Alertpage.isDisplayed();
		
		return value;
	}
	
	public boolean verify_NavigationOfManagerMenu() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(3000);
		Manager_Menu.click();
		MyListeners.extentTest.info("Manager_Menu Button Clicked");
		Thread.sleep(5000);
		value=Managerpage.isDisplayed();
		return value;
		
	}
		public boolean verify_NavigationOfHistoryMenu() throws InterruptedException {
			driver.navigate().back();
			Thread.sleep(3000);
			History_Menu.click();
			MyListeners.extentTest.info("History_Menu Button Clicked");
			Thread.sleep(5000);
			value=Historypage.isDisplayed();
			return value;
			
		}
			public boolean verify_NavigationOfMaintenanceMenu() throws InterruptedException {
				driver.navigate().back();
				Thread.sleep(3000);
				Maintenance_Menu.click();
				MyListeners.extentTest.info("Maintenance_Menu Button Clicked");
				Thread.sleep(10000);
				value=Maintenancepage.isDisplayed();
				return value;
				
			}
				public boolean verify_NavigationOfSearchMenu() throws InterruptedException {
					driver.navigate().back();
					Thread.sleep(3000);
					Search_Menu.click();
					MyListeners.extentTest.info("Search_Menu Button Clicked");
					Thread.sleep(5000);
					value=Searchpage.isDisplayed();
					driver.navigate().back();
					Thread.sleep(5000);
					return value;
					
		
		
		}
	
	
	
	

	}
