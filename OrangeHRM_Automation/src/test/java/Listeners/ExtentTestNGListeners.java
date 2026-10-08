package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.orangeHRM.factory.DriverFactory;

import utils.ExtentManager;
import utils.ScreenshotUtil;

public class ExtentTestNGListeners implements ITestListener {

	private static ExtentReports extent = ExtentManager.getExtentReports();

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

		test.get().fail(result.getThrowable());

		WebDriver driver = DriverFactory.getDriver();

		if (driver != null) {

			String screenshotPath = ScreenshotUtil.takeScreenshot(driver, result.getMethod().getMethodName());

			test.get().addScreenCaptureFromPath(screenshotPath);
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {

		test.get().skip("Test Skipped");
	}

	@Override
	public void onFinish(org.testng.ITestContext context) {

		extent.flush();
	}
}