package com.qa.Test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void doLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@BeforeMethod
	public void getproductTest() {
		componentPage.doHoverComponentElement("Monitors");
		productInfoPage = componentPage.doProductselection("Samsung SyncMaster 941BW");
	}

	@Test(priority = 0)
	public void doProductInfoTest() {
		Map<String,String> productInfo = productInfoPage.getProductInfoCheck();
		productInfo.forEach((K,V)->System.out.println(K +" "+ V));
		Assert.assertEquals(productInfo.get("Product Code"), "Product 6");
		Assert.assertEquals(productInfo.get("Availability"), "2-3 Days");
	}
	
	@Test(priority = 1)
	public void doProductPriceTest() {
		Map<String,String> productInfo = productInfoPage.getProductPriceInfo();
		productInfo.forEach((K,V)->System.out.println(K +" "+ V));
		Assert.assertEquals(productInfo.get("price"), "$200.00");
		Assert.assertEquals(productInfo.get("Ex Tax") ,"$200.00");
		
	}
	
	
	@Test(priority = 2)
	public void doProductaddToCartClickTest() {		
		productInfoPage.doAddToCart();
	}

	@Test(priority = 3,enabled = false)
	public void doProductSucessMessageTTest() {		
		String msg = productInfoPage.getSuccessMessageCheck();
		if(msg.contentEquals("Success: You have added Samsung SyncMaster 941BW to your shopping cart")) {
			System.out.println("Content Equal");
		}
	}
	
	@Test(priority = 4)
	public void doHomePageClick() {
		productInfoPage.doHomeBtnClick();
	}

}
