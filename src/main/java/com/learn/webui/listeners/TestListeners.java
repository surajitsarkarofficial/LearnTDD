package com.learn.webui.listeners;

import com.learn.webui.commons.TestUtils;
import com.learn.webui.managers.DriverManager;
import com.learn.webui.managers.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

/**
 *  Listener classs
 * @author surajit.sarkar
 */
public final class TestListeners implements ITestListener {


    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest exTest = ExtentManager.getInstance().getExtentReport().createTest(result.getMethod().getMethodName());
        ExtentManager.getInstance().setExtentTest(exTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ExtentManager.getInstance().getExtentTest().log(Status.PASS,
                "Test case " + result.getMethod().getMethodName() + " Passed.");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentManager.getInstance().getExtentTest().log(Status.FAIL,
                "Test case " + result.getMethod().getMethodName() + " Failed.");

        ExtentManager.getInstance().getExtentTest().log(Status.FAIL, result.getThrowable());

        File scr = ((TakesScreenshot) DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
        String scrPath = System.getProperty("user.dir") + File.separator + "Reports" + File.separator +
                "Screenshots" + File.separator + TestUtils.getCurrentDateTime("dd-MM-yy-hh-mm-ss") + ".png";
        File dest = new File(scrPath);

        try {
            FileUtils.copyFile(scr, dest);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            ExtentManager.getInstance().getExtentTest().addScreenCaptureFromPath(scrPath, "Failed screenshot");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ExtentManager.getInstance().removeExtentTest();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentManager.getInstance().getExtentTest().log(Status.SKIP,
                "Test case " + result.getMethod().getMethodName() + " Skipped.");
        ExtentManager.getInstance().removeExtentTest();
    }

}
