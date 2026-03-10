
package com.cleargear.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.cleargear.base.Base;
import com.cleargear.driver.DriverManager;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Helper;

public class POM_AlertModuleCG extends Base
{
	public JavascriptExecutor js;
	public WebDriverWait wait;

	public POM_AlertModuleCG()
	{
		driver = DriverManager.getDriver();
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
	}

	// ================== WebElements ==================

			@FindBy(xpath = "(//div[contains(@class,'items-center justify-center')]//div[normalize-space()='Active'])[1]/..")
			private WebElement Active_Module;

			@FindBy(xpath = "(//div[contains(@class,'items-center justify-center')]//div[normalize-space()='History'])[1]/..")
			private WebElement History_Module;

			@FindBy(xpath = "(//div[contains(@class,'items-center justify-center')]//div[normalize-space()='Statistics'])[1]/..")
			private WebElement Statistics_Module;

			// ================== Common Verification ==================

			public void verifyModule(WebElement element, String moduleName) throws Throwable
			{
				wait.until(ExpectedConditions.visibilityOf(element));
				Helper.highlightElement(driver, element);

				Rectangle rect = element.getRect();

				Reporter.log(moduleName + " Displayed :- " + element.isDisplayed());
				Reporter.log(moduleName + " Height :- " + rect.getHeight());
				Reporter.log(moduleName + " Width :- " + rect.getWidth());
				Reporter.log(moduleName + " Text :- " + element.getText());

				ExtentReporter.extentReport.setSystemInfo(
						moduleName + " Displayed :- " + element.isDisplayed(), null);
				ExtentReporter.extentReport.setSystemInfo(
						moduleName + " Height :- " + rect.getHeight(), null);
				ExtentReporter.extentReport.setSystemInfo(
						moduleName + " Width :- " + rect.getWidth(), null);
				ExtentReporter.extentReport.setSystemInfo(
						moduleName + " Text :- " + element.getText(), null);
			}

			// ================== Verification Methods ==================

			public void verifyActiveModule() throws Throwable
			{
				verifyModule(Active_Module, "Active Module");
			}

			public void verifyHistoryModule() throws Throwable
			{
				verifyModule(History_Module, "History Module");
			}

			public void verifyStatisticsModule() throws Throwable
			{
				verifyModule(Statistics_Module, "Statistics Module");
			}

			public void verifyAlertModules() throws Throwable
			{
				verifyActiveModule();
				verifyHistoryModule();
				verifyStatisticsModule();
			}

			// ================== Click Actions ==================

			public void clickActiveModule() throws Throwable
			{
				wait.until(ExpectedConditions.elementToBeClickable(Active_Module));
				Helper.highlightElement(driver, Active_Module);
				Active_Module.click();
			}

			public void clickHistoryModule() throws Throwable
			{
				wait.until(ExpectedConditions.elementToBeClickable(History_Module));
				Helper.highlightElement(driver, History_Module);
				History_Module.click();
			}

			public void clickStatisticsModule() throws Throwable
			{
				wait.until(ExpectedConditions.elementToBeClickable(Statistics_Module));
				Helper.highlightElement(driver, Statistics_Module);
				Statistics_Module.click();
			}
}



