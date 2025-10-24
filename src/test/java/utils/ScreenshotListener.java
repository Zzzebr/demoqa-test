package utils;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


import java.io.File;
import java.io.IOException;


public class ScreenshotListener implements ITestListener {


    @Override
    public void onTestFailure(ITestResult result) {
        Object driver = result.getTestContext().getAttribute("driver");
        if (driver instanceof WebDriver) {
            saveScreenshot((WebDriver) driver);
        }
    }


    @Attachment(value = "Failure screenshot", type = "image/png")
    public byte[] saveScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }


    // other methods left empty
    public void onTestStart(ITestResult result) {}
    public void onTestSuccess(ITestResult result) {}
    public void onTestSkipped(ITestResult result) {}
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}
    public void onStart(ITestContext context) {}
    public void onFinish(ITestContext context) {}
}
