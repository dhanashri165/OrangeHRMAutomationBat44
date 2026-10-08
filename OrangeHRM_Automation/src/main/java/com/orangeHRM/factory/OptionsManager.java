package com.orangeHRM.factory;

import org.openqa.selenium.chrome.ChromeOptions;

public class OptionsManager {

	public ChromeOptions getChromeOptions() {

		ChromeOptions options = new ChromeOptions();

		options.addArguments("--start-maximized");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		// options.addArguments("--headless=new"); // for Jenkins execution
		return options;
	}
}