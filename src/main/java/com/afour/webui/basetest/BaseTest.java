package com.afour.webui.basetest;

import com.afour.webui.commons.TestUtils;
import com.afour.webui.managers.DriverManager;
import com.afour.webui.managers.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * This is the Parent of all the test classes
 * @author surajit.sarkar
 */
public class BaseTest {


    @BeforeSuite(alwaysRun = true)
    public void beforeSuiteSetup()
    {
        ExtentManager.getInstance().initExtentReport();
    }

    @Parameters("browser")
    @BeforeTest(alwaysRun = true)
    public void beforeTestSetup(@Optional("Chrome") String brwsr) throws Exception {
        String browser = System.getProperty("browser");
        if(Objects.isNull(browser)|| browser.isEmpty() || browser.equals(""))
        {
            browser=brwsr;
        }
        DriverManager.getInstance().initDriver(browser);

    }
    @BeforeMethod(alwaysRun = true)
    public void beforeMethodSetup(Method method)
    {
        ExtentTest exTest= ExtentManager.getInstance().getExtentReport().createTest(method.getName());
        ExtentManager.getInstance().setExtentTest(exTest);
    }
    @AfterMethod(alwaysRun = true)
    public void afterMethodTearDown(ITestResult result)
    {
        if(result.getStatus()==1)
        {
            ExtentManager.getInstance().getExtentTest().log(Status.PASS,
                    "Test case "+result.getMethod().getMethodName()+ " Passed.");
        }else if(result.getStatus()==2)
        {
            ExtentManager.getInstance().getExtentTest().log(Status.FAIL,
                    "Test case "+result.getMethod().getMethodName()+ " Failed.");

            ExtentManager.getInstance().getExtentTest().log(Status.FAIL, result.getThrowable());

            File scr =  ((TakesScreenshot) DriverManager.getInstance().getDriver()).getScreenshotAs(OutputType.FILE);
            String scrPath = System.getProperty("user.dir")+File.separator+"Reports"+File.separator+
                    "Screenshots"+File.separator+ TestUtils.getCurrentDateTime("dd-MM-yy-hh-mm-ss")+".png";
            File dest = new File(scrPath);

            try {
                FileUtils.copyFile(scr,dest);
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                ExtentManager.getInstance().getExtentTest().addScreenCaptureFromPath(scrPath,"Failed screenshot");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(result.getStatus()==3){
            ExtentManager.getInstance().getExtentTest().log(Status.SKIP,
                    "Test case "+result.getMethod().getMethodName()+ " Skipped.");
        }else{
            ExtentManager.getInstance().getExtentTest().log(Status.ERROR,
                    "Test case "+result.getMethod().getMethodName()+ " Unknown Status.");
        }
        ExtentManager.getInstance().removeExtentTest();
    }
    @AfterTest(alwaysRun = true)
    public void afterTestTearDown() throws Exception {
        DriverManager.getInstance().closeDriver();

    }

    @AfterSuite(alwaysRun = true)
    public void afterSuiteTearDown()
    {
        ExtentManager.getInstance().publishExtentReport();
    }


}

