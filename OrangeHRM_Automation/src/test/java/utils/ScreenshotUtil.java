package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	public static String takeScreenshot(WebDriver driver, String testName) {

		String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

		String folderPath = System.getProperty("user.dir") + "/test-output/screenshots/";

		File folder = new File(folderPath);

		if (!folder.exists()) {
			folder.mkdirs();
		}

		String filePath = folderPath + testName + "_" + timestamp + ".png";

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		File destination = new File(filePath);

		try {

			Files.copy(source.toPath(), destination.toPath(), StandardCopyOption.REPLACE_EXISTING);

		} catch (IOException e) {

			e.printStackTrace();
		}

		return filePath;
	}
}