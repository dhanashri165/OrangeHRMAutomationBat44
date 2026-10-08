package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.orangeHRM.factory.DriverFactory;

public class Base {

	protected WebDriver driver;
	protected Properties prop;

	@BeforeMethod
	public void setUp() throws IOException {

		prop = new Properties();

		FileInputStream fis = new FileInputStream("src/main/resources/configuration/config.qa.properties");

		prop.load(fis);

		String browser = prop.getProperty("browser");

		driver = DriverFactory.initDriver(browser);

		driver.get(prop.getProperty("url"));
	}

	/*
	 * @AfterMethod public void tearDown() {
	 * 
	 * DriverFactory.quitDriver(); }
	 */
}