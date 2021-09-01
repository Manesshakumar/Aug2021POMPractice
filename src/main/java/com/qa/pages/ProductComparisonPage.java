package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.ElementUtil;

public class ProductComparisonPage {

	private WebDriver driver;
	private ElementUtil elementUtil;

	private By rows = By.xpath("//table[@class = 'table table-bordered']/tbody[1]/tr");
	private By columns = By.xpath("//table[@class = 'table table-bordered']/tbody[1]/tr/td");
	private By productDetail = By.xpath("//table[@class = 'table table-bordered']/tbody[1]/tr/td[1]");
	private By continueBtn = By.xpath("//a[text() ='Continue']");
	private By removeBtn = By.xpath("//a[text() ='Remove']");
	
	static String column_before_xpath = "//table[@class = 'table table-bordered']/tbody[1]/tr/td";

	public ProductComparisonPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}

	public void getDataFromProductComparisonTable() {
		List<WebElement> row = elementUtil.getElements(rows);
		int rowSize = row.size();
		System.out.println("The Row size is : " + rowSize);
		System.out.println("===================================================");

		// Column count:
		int columnsSize = elementUtil.getElements(columns).size();
		System.out.println("The columns size is : " + columnsSize);
		System.out.println("===================================================");
		
		// Fetch Single Column Value:
		List<WebElement> productDesc = elementUtil.getElements(productDetail);
		for (int i = 0; i < productDesc.size(); i++) {
			System.out.println("The productCategory : " + productDesc.get(i).getText());
		}
		System.out.println("===================================================");

		//Fetch all Data:
		List<WebElement> productVal = driver.findElements(By.xpath(column_before_xpath));
		for (WebElement x : productVal) {
			System.out.println(x.getText());
		}

	}
	
	public void doClickReomveBtn() {
		elementUtil.doClick(removeBtn);
	}
	
	public void doClickContinueBtn() {
		elementUtil.doClick(continueBtn);
	}

}
