package com.qa.pages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.Utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil elementUtil;
	
	private By productHeaderName = By.xpath("//div[@class='btn-group']//following-sibling::h1");
	private By productInfoValue = By.xpath("(//div[@class='btn-group']//following-sibling::ul[@class ='list-unstyled'])[1]/li");
	private By productPrice = By.xpath("(//div[@class='btn-group']//following-sibling::ul[@class ='list-unstyled'])[2]/li[1]");
    private By priceTax = By.xpath("(//div[@class='btn-group']//following-sibling::ul[@class ='list-unstyled'])[2]/li[2]");
    private By addToCartBtn = By.xpath("//button [@id = 'button-cart' and text() = 'Add to Cart']");
    private By homeBtn = By.xpath("(//ul[@class = 'breadcrumb']/li)[1]/a");
    
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public Map<String, String> getProductInfoCheck() {
		Map<String,String> productMap = new HashMap<String,String>();
		String prodHeader= elementUtil.getElement(productHeaderName).getText();
		productMap.put("ProductName", prodHeader);
		List<WebElement> prodList = elementUtil.getElements(productInfoValue);
		for(WebElement x: prodList) {
			String prodDesc[] = x.getText().split(":");
			String prodKey  = prodDesc[0].trim();
			String prodVal  = prodDesc[1].trim();
			productMap.put(prodKey, prodVal);
		}
		return productMap;
	}
	
	public Map<String, String> getProductPriceInfo() {
		Map<String,String> productpriceMap = new HashMap<String,String>();
		WebElement prodPrice = elementUtil.getElement(productPrice);
		String priceVal = prodPrice.getText();
		String tax[] = elementUtil.getElement(priceTax).getText().split(":");
		String taxText = tax[0].trim();
		String taxVal = tax[1].trim();
		productpriceMap.put("price", priceVal);
		productpriceMap.put(taxText, taxVal);
		return productpriceMap;
	}
	
	public void doAddToCart() {
		elementUtil.doClick(addToCartBtn);
	}
	
	public String getSuccessMessageCheck() {
		doAddToCart();
		Alert alert = driver.switchTo().alert();
		String message = alert.getText();
		return message;
		
	}
	
	public HomePage doHomeBtnClick() {
		elementUtil.getElement(homeBtn).click();
		return new HomePage(driver);
	}
	

}
