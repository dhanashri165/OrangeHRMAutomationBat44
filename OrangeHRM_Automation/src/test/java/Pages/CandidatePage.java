package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CandidatePage {

	private WebDriver driver;

	// Add button
	private By addButton = By.xpath("//button[normalize-space()='Add']");

	// Candidate fields
	private By firstName = By.xpath("//input[@placeholder='First Name']");

	private By middleName = By.xpath("//input[@placeholder='Middle Name']");

	private By lastName = By.xpath("//input[@placeholder='Last Name']");

	private By vacancyDropdown = By.xpath("//label[normalize-space()='Vacancy']"
			+ "/ancestor::div[contains(@class,'oxd-input-group')]" + "//div[contains(@class,'oxd-select-text')]");

	private By email = By.xpath("//label[text()='Email']/following::input[1]");

	private By contactNumber = By.xpath("//label[normalize-space()='Contact Number']"
			+ "/ancestor::div[contains(@class,'oxd-input-group')]" + "//input");

	private By keywords = By.xpath(
			"//label[normalize-space()='Keywords']" + "/ancestor::div[contains(@class,'oxd-input-group')]" + "//input");

	private By notes = By.xpath(
			"//label[normalize-space()='Notes']" + "/ancestor::div[contains(@class,'oxd-input-group')]" + "//textarea");

	private By saveButton = By.xpath("//button[@type='submit']");

	private By successMessage = By.xpath("//div[contains(@class,'oxd-toast-content')]");

	public CandidatePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAdd() {

		driver.findElement(addButton).click();
	}

	public void enterFirstName(String value) {

		driver.findElement(firstName).sendKeys(value);
	}

	public void enterMiddleName(String value) {

		driver.findElement(middleName).sendKeys(value);
	}

	public void enterLastName(String value) {

		driver.findElement(lastName).sendKeys(value);
	}

	public void selectVacancy(String vacancyName) {

		driver.findElement(vacancyDropdown).click();

		By vacancyOption = By.xpath("//div[@role='option']" + "//span[normalize-space()='" + vacancyName + "']");

		driver.findElement(vacancyOption).click();
	}

	public void enterEmail(String emailAddress) {

		driver.findElement(email).sendKeys(emailAddress);
	}

	public void enterContactNumber(String number) {

		driver.findElement(contactNumber).sendKeys(number);
	}

	public void enterKeywords(String value) {

		driver.findElement(keywords).sendKeys(value);
	}

	public void enterNotes(String value) {

		driver.findElement(notes).sendKeys(value);
	}

	public void clickSave() {

		driver.findElement(saveButton).click();
	}

	public boolean isCandidateCreated() {

		return driver.findElement(successMessage).isDisplayed();
	}

	public void addCandidate(String first, String middle, String last, String vacancy, String emailId, String contact,
			String keyword, String note) {

		clickAdd();

		enterFirstName(first);
		enterMiddleName(middle);
		enterLastName(last);

		selectVacancy(vacancy);

		enterEmail(emailId);
		enterContactNumber(contact);

		enterKeywords(keyword);
		enterNotes(note);

		clickSave();
	}
}