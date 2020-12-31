package com.afour.webui.managers;

import com.afour.webui.commons.TestUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;

public final class ExtentManager {

    private ExtentManager()
    {

    }

    private static ExtentManager instance = new ExtentManager();

    public static ExtentManager getInstance()
    {

        return instance;
    }


    private static ExtentReports extentReport ;

    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public ExtentReports getExtentReport()
    {
        return extentReport;
    }
    public void initExtentReport()
    {
        String dateTime = TestUtils.getCurrentDateTime("dd-MM-yyy-HH-mm-ss");
        String reportPath = System.getProperty("user.dir")+ File.separator+"Reports"+File.separator
                +"ExecutionReport_"+dateTime +".html";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        extentReport = new ExtentReports();
        extentReport.attachReporter(sparkReporter);

        sparkReporter.config().setDocumentTitle("Test Automation Execution Report");
        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Test Report");
    }

    public void publishExtentReport()
    {
        extentReport.flush();
    }

    public void setExtentTest(ExtentTest exTest)
    {
        extentTest.set(exTest);
    }

    public ExtentTest getExtentTest()
    {
        return extentTest.get();
    }

    public void removeExtentTest()
    {
        extentTest.remove();
    }


}
