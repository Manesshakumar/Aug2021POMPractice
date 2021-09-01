package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.ElementUtil;

public class DesktopComponentSelectionPage {

	
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By desktopCategory = By.cssSelector("div[class = 'caption'] h4 a");
	private By compareProdBtn = By.xpath("(//button[contains(@data-original-title , 'Compare this Product')])[1]");
	private By containerSelection = By.xpath("//ul[contains(@class , 'breadcrumb')]/li");
	private By productCompareBtn = By.xpath("//div[@class = 'form-group']/a");
	
	public DesktopComponentSelectionPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public void getDesktopCategorySelection() {
		List<WebElement> categoryList = elementUtil.getElements(desktopCategory);
		for(WebElement x : categoryList) {
			String desktopOptions = x.getText();
			if (desktopOptions.equals("MacBook Air")) {
			x.click();
			break;
			}
		}
	}
	
	public void doClickCompareProductButton() {
		elementUtil.doClick(compareProdBtn);
	}
	
	public void doClickProductContainer() {
		List<WebElement> containerList = elementUtil.getElements(containerSelection);
		for(WebElement x : containerList) {
			String desktopOptions = x.getText();
			if (desktopOptions.equals("Desktops")) {
			x.click();
			break;
			}
		}
	}
	public ProductComparisonPage doClickCompareProductButtonDesktop() {
		elementUtil.doClick(productCompareBtn);
		return new ProductComparisonPage(driver);
	}
	
}
