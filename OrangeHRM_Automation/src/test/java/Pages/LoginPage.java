package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;

	// Locators
	private By username = By.name("username");

	private By password = By.name("password");

	private By loginButton = By.xpath("//button[@type='submit']");

	private By dashboardText = By.xpath("//h6[normalize-space()='Dashboard']");

	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Actions

	public void enterUsername(String userName) {

		driver.findElement(username).sendKeys(userName);
	}

	public void enterPassword(String passWord) {

		driver.findElement(password).sendKeys(passWord);
	}

	public DashboardPage clickLogin() {

		driver.findElement(loginButton).click();

		return new DashboardPage(driver);
	}

	public DashboardPage login(String userName, String passWord) {

		enterUsername(userName);
		enterPassword(passWord);

		return clickLogin();
	}

	public boolean isDashboardDisplayed() {

		return driver.findElement(dashboardText).isDisplayed();
	}
}