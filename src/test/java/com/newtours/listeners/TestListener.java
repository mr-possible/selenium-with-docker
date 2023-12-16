package com.newtours.listeners;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {

    /**
     * TestNG will automatically invoke this method when a test fails.
     *
     * @param result
     */
    @Override
    public void onTestFailure(ITestResult result) {
        // This is a good place to keep the logic for capturing the screenshots.
        // For that, we need webdriver instance. We will get that by the help of context provided by testng.
        TakesScreenshot driver = (TakesScreenshot) result.getTestContext().getAttribute("driver");
        String ss = driver.getScreenshotAs(OutputType.BASE64);
        String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
        String htmlImage = String.format(htmlImageFormat, ss);
        Reporter.log(htmlImage);
    }
}
