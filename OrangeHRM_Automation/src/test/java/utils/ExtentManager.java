package utils;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;

	public static ExtentReports getExtentReports() {

		if (extent == null) {

			String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";

			ExtentSparkReporter spark = new ExtentSparkReporter(new File(reportPath));

			spark.config().setDocumentTitle("OrangeHRM Automation Report");

			spark.config().setReportName("OrangeHRM Recruitment Automation");

			extent = new ExtentReports();

			extent.attachReporter(spark);

			extent.setSystemInfo("Project", "OrangeHRM Automation");

			extent.setSystemInfo("Tester", "Dhanashri");

			extent.setSystemInfo("Environment", "QA");
		}

		return extent;
	}
}