package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

	private WebDriver driver;

	private By dashboardHeading = By.xpath("//h6[normalize-space()='Dashboard']");

	private By recruitmentMenu = By.xpath("//span[normalize-space()='Recruitment']");

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isDashboardDisplayed() {

		return driver.findElement(dashboardHeading).isDisplayed();
	}

	public RecruitmentPage clickRecruitment() {

		driver.findElement(recruitmentMenu).click();

		return new RecruitmentPage(driver);
	}
}