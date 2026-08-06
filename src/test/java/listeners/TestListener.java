package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import reports.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getReport();

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {

        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());

        test.set(extentTest);

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        test.get().pass("Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

        BaseTest base = (BaseTest) result.getInstance();

        String screenshot = ScreenshotUtil.captureScreenshot(
                base.getDriver(),
                result.getMethod().getMethodName());

        test.get().fail(result.getThrowable());

        try {

            test.get().addScreenCaptureFromPath(screenshot);

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    @Override
    public void onFinish(org.testng.ITestContext context) {

        extent.flush();

    }

}