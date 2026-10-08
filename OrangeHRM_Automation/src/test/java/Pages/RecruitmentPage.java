package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage {

	private WebDriver driver;

	private By recruitmentHeading = By.xpath("//h6[normalize-space()='Recruitment']");

	private By candidatesTab = By.xpath("//a[normalize-space()='Candidates']");

	private By vacanciesTab = By.xpath("//a[normalize-space()='Vacancies']");

	public RecruitmentPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean isRecruitmentPageDisplayed() {

		return driver.findElement(recruitmentHeading).isDisplayed();
	}

	public CandidatePage clickCandidates() {

		driver.findElement(candidatesTab).click();

		return new CandidatePage(driver);
	}

	public VacancyPage clickVacancies() {

		driver.findElement(vacanciesTab).click();

		return new VacancyPage(driver);
	}
}