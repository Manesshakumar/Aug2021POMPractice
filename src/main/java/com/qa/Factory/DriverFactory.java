package com.qa.Factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	WebDriver driver;

	public Properties init_prop() {
		Properties prop = new Properties();
		try {
			FileInputStream io = new FileInputStream("./src/test/resources/com/qa/config/config.properties");
			prop.load(io);
		} catch (FileNotFoundException e) {
		} catch (IOException e) {

		}

		return prop;

	}
	
	public WebDriver init_driver(String browser) {
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			System.out.println("Please pass correct browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		return driver;
	}
	/**
	 * Screenshot Feature
	 * @return path
	 */
	public String getScreenshot() {		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	return path;
		
	}
}
