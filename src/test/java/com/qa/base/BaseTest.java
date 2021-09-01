package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.Factory.DriverFactory;
import com.qa.pages.ComponentPage;
import com.qa.pages.DesktopComponentSelectionPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductComparisonPage;
import com.qa.pages.ProductInfoPage;

public class BaseTest {
	
	DriverFactory df;
	public Properties prop;
	WebDriver driver;
	public LoginPage loginPage;
	public ComponentPage componentPage;
	public ProductInfoPage productInfoPage;
	public HomePage homePage;
	public DesktopComponentSelectionPage desktopComponentSelectionPage;
	public ProductComparisonPage productComparisonPage;
	
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop = df.init_prop();
		String url = prop.getProperty("url");
		String browser = prop.getProperty("browser");
		driver = df.init_driver(browser);
		driver.get(url);
		loginPage = new LoginPage(driver);
		componentPage = new ComponentPage(driver);
		productInfoPage = new ProductInfoPage(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
