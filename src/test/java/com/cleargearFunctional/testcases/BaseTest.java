package com.cleargearFunctional.testcases;

import java.lang.reflect.Method;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.cleargear.driver.DriverFactory;
import com.cleargear.driver.DriverManagerNew;
import com.cleargear.utils.ExtendReports;
import com.cleargear.utils.PopertyUtils;

public class BaseTest {
	
	protected WebDriver driver;

//    // --------------------- Suite-Level Setup ---------------------
//    @BeforeSuite(alwaysRun = false)
//    public void beforeSuite(ITestContext context) {
//        String suiteName = context.getSuite().getName(); // Get suite name
//        String testClassName = this.getClass().getSimpleName(); // Get class name
//
//        // Decide report name dynamically
//        String reportName = suiteName == null || suiteName.isEmpty() || suiteName.equalsIgnoreCase("Default suite")
//                ? testClassName
//                : suiteName;
//
//        try {
//            ExtendReports.initReports(testClassName, reportName);
//        } catch (Exception e) {
//            e.printStackTrace();
//            throw new RuntimeException("❌ Failed to initialize ExtentReports: " + e.getMessage());
//        }
//    }
//
//    @AfterSuite(alwaysRun = false)
//    public void afterSuite() {
//        ExtendReports.teardownReports();
//    }

    // --------------------- Class-Level Setup ---------------------
//    @BeforeClass(alwaysRun = false)
//    public void beforeClass() {
//        // Initialize driver for this class
//        String browser = PopertyUtils.get("browserName");
//        driver = DriverFactory.initDriver(browser);
//        DriverManagerNew.setDriver(driver);
//        driver.get(PopertyUtils.get("url"));
//    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
    	DriverFactory.quitDriver();
    }

    // --------------------- Method-Level Setup ---------------------
//    @BeforeMethod(alwaysRun = false)
//    public void beforeMethod(Method method) {
//        // Create a test node in ExtentReports
//        String methodDescription = method.getAnnotation(Test.class) != null
//                ? method.getAnnotation(Test.class).description()
//                : method.getName();
//
//        ExtendReports.createTestForMethod(this.getClass().getSimpleName(), method.getName(), methodDescription);
//    }

}
