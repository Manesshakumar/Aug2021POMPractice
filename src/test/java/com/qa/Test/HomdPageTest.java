package com.qa.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class HomdPageTest extends BaseTest{
	@BeforeClass
	public void doLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage = productInfoPage.doHomeBtnClick();
	}
	
	
	@Test(priority = 0)
	public void doProductContainerSizeTest() {
		int productAvailabilityCount = homePage.productContainer().size();
		Assert.assertEquals(productAvailabilityCount, 8);
	}
	
	@Test(priority = 1)
	public void desktopProductSelectionTest() {
		homePage.hoverOnSelectionDesktop();
	}
}
