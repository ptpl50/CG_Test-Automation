package com.cleargear.utils;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentreportTestManager {
	
	private ExtentreportTestManager() {
        // Prevent object creation
    }

    private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

    public static ExtentTest getExtentTest() {
        return TEST.get();
    }

    public static void setExtentTest(ExtentTest extentTest) {
        TEST.set(extentTest);
    }

    public static void unload() {
        TEST.remove();
    }

}
