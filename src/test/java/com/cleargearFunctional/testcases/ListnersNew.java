package com.cleargearFunctional.testcases;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.cleargear.driver.DriverFactory;
import com.cleargear.driver.DriverManagerNew;
import com.cleargear.utils.ExtendReports;
import com.cleargear.utils.ExtentLogger;
import com.cleargear.utils.ExtentreportTestManager;
import com.cleargear.utils.PopertyUtils;

public class ListnersNew  implements ISuiteListener, ITestListener {
	
	private static Set<String> failedTests = new HashSet<>();
	protected WebDriver driver;

    @Override
    public void onStart(ISuite suite) {
    	String browser = PopertyUtils.get("browserName");
        driver = DriverFactory.initDriver(browser);
        DriverManagerNew.setDriver(driver);
        driver.get(PopertyUtils.get("url"));
        try {
            String suiteName = suite.getName();
            String testClassName = suite.getXmlSuite().getTests().get(0).getClasses().get(0).getName();
            testClassName = testClassName.substring(testClassName.lastIndexOf(".") + 1);

            // Initialize ExtentReports
            ExtendReports.initReports(testClassName, suiteName);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestStart(ITestResult result) {
        String className = result.getMethod().getTestClass().getName();
        className = className.substring(className.lastIndexOf(".") + 1);

        String methodName = result.getMethod().getMethodName();
        String description = result.getMethod().getDescription() != null ? 
                             result.getMethod().getDescription() : "No description";

        ExtentTest methodTest = ExtendReports.createTestForMethod(className, methodName, description);
        ExtentreportTestManager.setExtentTest(methodTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName() + " passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        failedTests.add(result.getTestClass().getName() + "#" + result.getMethod().getMethodName());
        ExtentLogger.fail(result.getName() + " failed");
        ExtentreportTestManager.getExtentTest().fail(result.getThrowable().toString());
        ExtentreportTestManager.getExtentTest().fail(Arrays.toString(result.getThrowable().getStackTrace()));
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentLogger.skip(result.getName() + " skipped");
    }

    @Override
    public void onFinish(ISuite suite) {
        // Write failed tests to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("failed-tests.txt"))) {
            for (String failedTest : failedTests) {
                writer.write(failedTest);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Teardown ExtentReports
        ExtendReports.teardownReports();
    }


}
