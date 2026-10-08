package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class VacancyPage {

	private WebDriver driver;

	private By addButton = By.xpath("//button[normalize-space()='Add']");

	private By jobTitleDropdown = By.xpath("//label[normalize-space()='Job Title']"
			+ "/ancestor::div[contains(@class,'oxd-input-group')]" + "//div[contains(@class,'oxd-select-text')]");

	private By vacancyName = By.xpath("//label[normalize-space()='Vacancy Name']"
			+ "/ancestor::div[contains(@class,'oxd-input-group')]" + "//input");

	private By hiringManager = By.xpath("//label[normalize-space()='Hiring Manager']"
			+ "/ancestor::div[contains(@class,'oxd-input-group')]" + "//input");

	private By numberOfPositions = By.xpath("//label[normalize-space()='Number of Positions']"
			+ "/ancestor::div[contains(@class,'oxd-input-group')]" + "//input");

	private By saveButton = By.xpath("//button[@type='submit']");

	public VacancyPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAdd() {

		driver.findElement(addButton).click();
	}

	public void enterVacancyName(String name) {

		driver.findElement(vacancyName).sendKeys(name);
	}

	public void enterHiringManager(String manager) {

		driver.findElement(hiringManager).sendKeys(manager);
	}

	public void enterNumberOfPositions(String number) {

		driver.findElement(numberOfPositions).sendKeys(number);
	}

	public void clickSave() {

		driver.findElement(saveButton).click();
	}
}