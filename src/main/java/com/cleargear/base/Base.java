package com.cleargear.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.cleargear.driver.DriverManager;
import com.cleargear.pages.POM_ActiveModuleCG;
import com.cleargear.pages.POM_AlertModuleCG;
import com.cleargear.pages.POM_AlertsMenuPage;
import com.cleargear.pages.POM_ClearGear_Page;
import com.cleargear.pages.POM_CreateNew_User_Page;
import com.cleargear.pages.POM_ClearGear_History;
import com.cleargear.pages.POM_MainMenu_Page;
import com.cleargear.pages.POM_SignIn_Page;
import com.cleargear.pages.POM_UserManagementPage;
import com.cleargear.utils.ExtentReporter;
import com.cleargear.utils.Utilities;

public class Base extends ExtentReporter
{
	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public POM_SignIn_Page signin;
	public POM_MainMenu_Page mainMenu;
	public POM_UserManagementPage userManagement;
	public POM_CreateNew_User_Page createUser;
	public POM_ClearGear_Page clearGear;
	public POM_AlertModuleCG alertModule;
	public POM_AlertsMenuPage alertMenu;
	public POM_ActiveModuleCG Active;
	public POM_ClearGear_History History;
	
	public Base() 
	{
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cleargear\\config\\config.properties");

		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\cleargear\\testdata\\testdata.properties");

		try {
			FileInputStream dataFis = new FileInputStream(dataPropFile);
			dataProp.load(dataFis);
		}catch(Throwable e) {
			e.printStackTrace();
		}

		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}

	}

	@Parameters("browserName")
	@BeforeClass
	public void setup(String browserName)
	{
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			DriverManager.setDriver(driver);
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			DriverManager.setDriver(driver);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
			DriverManager.setDriver(driver);
		}
		
		extentReport.setSystemInfo("Browser ",browserName);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
		//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		signin=new POM_SignIn_Page();
		mainMenu = new POM_MainMenu_Page();
		userManagement = new POM_UserManagementPage();
		createUser = new POM_CreateNew_User_Page();
		clearGear = new POM_ClearGear_Page();
		alertModule = new POM_AlertModuleCG();
		alertMenu = new POM_AlertsMenuPage();
		Active = new POM_ActiveModuleCG();
	}
	
	@AfterClass
	public void teardown()
	{
		DriverManager.getDriver().quit();
        DriverManager.unload();
        
	}
}