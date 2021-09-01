package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.Utils.ElementUtil;

public class HomePage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	private By containerElements = By.xpath("//ul[@class='nav navbar-nav']/li");
	private By desktopElement = By.xpath("(//ul[@class='nav navbar-nav']/li)[1]/a");
	private By dropdownOption = By.xpath("(//div[@class='dropdown-menu'])[1]//a");
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public List<WebElement> productContainer() {
		return elementUtil.getElements(containerElements);
	}
	
	public DesktopComponentSelectionPage hoverOnSelectionDesktop() {
		Actions action = new Actions(driver);
		action.moveToElement(elementUtil.getElement(desktopElement)).click().build().perform();
		List<WebElement> optionList = elementUtil.visibilityOfAllElements(dropdownOption, 20);
		System.out.println(optionList.size());
		for(WebElement x : optionList) {
			String dropdownText = x.getText();
			if(dropdownText.contains("Show All Desktops")) {
				x.click();
			}
		}
		
		return new DesktopComponentSelectionPage(driver);
	}
	
}
