package com.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.Utils.ElementUtil;

public class ComponentPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	private By componentEle = By.xpath("(//a[text() = 'Components'])[1]");
	private By componentDropdownOption = By.xpath("(//a[text() = 'Components'])[1]//following-sibling::div//ul/li/a");
    private By productListItems = By.xpath("//div[@class= 'product-thumb']/div/a/img");
    
	public ComponentPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public void doHoverComponentElement(String componentValue) {
		Actions action = new Actions(driver);
		action.moveToElement(elementUtil.getElement(componentEle)).perform();
		List<WebElement> optionList = elementUtil.visibilityOfAllElements(componentDropdownOption, 10);
		System.out.println(optionList.size());
		for(WebElement x :optionList) {
			String optionsText = x.getText();
			if(optionsText.contains(componentValue)) {
				x.click();
				break;
			}
		}
	}
	
	
	public String screenTransitionTitleCheck() {
		return elementUtil.getTitle();
	}
	
	public List<String> getproductItems() {
		List<String> productName = new ArrayList<String>();
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class= 'product-thumb']/div/a/img"));
		for(WebElement x : productList) {
			String productTitle = x.getAttribute("title");
			productName.add(productTitle);
		}
		return productName;
	}
	
	public ProductInfoPage doProductselection(String product) {
		List<WebElement> productList = elementUtil.getElements(productListItems);
		for(WebElement x : productList) {
			String productTitle = x.getAttribute("title");
			if(productTitle.equals(product)) {
				x.click();
				break;
			}
		}
		
		return new ProductInfoPage(driver);
	}

}
