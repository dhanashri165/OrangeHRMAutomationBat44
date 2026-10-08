package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base;
import Pages.CandidatePage;
import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.RecruitmentPage;
import utils.RetryAnalyzer;

public class TestRecruitmentCandidate extends Base {

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void addNewCandidate() {

		// Login
		LoginPage loginPage = new LoginPage(driver);

		DashboardPage dashboardPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));

		// Navigate to Recruitment
		RecruitmentPage recruitmentPage = dashboardPage.clickRecruitment();

		// Click Candidates
		CandidatePage candidatePage = recruitmentPage.clickCandidates();

		// Add Candidate
		candidatePage.addCandidate("Dhanashri", "Automation", "Tester", "Senior QA Lead",

				"dhanashri" + System.currentTimeMillis() + "@gmail.com",

				"9876543210", "Selenium, Java, TestNG", "Automation practice candidate");

		// Validation
		Assert.assertTrue(candidatePage.isCandidateCreated(), "Candidate was not created successfully");
	}
}