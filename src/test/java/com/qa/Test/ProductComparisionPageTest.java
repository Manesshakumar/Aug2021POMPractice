package com.qa.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class ProductComparisionPageTest extends BaseTest{
	
	@BeforeClass
	public void doLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage = productInfoPage.doHomeBtnClick();
		desktopComponentSelectionPage = homePage.hoverOnSelectionDesktop();
		desktopComponentSelectionPage.getDesktopCategorySelection();
		desktopComponentSelectionPage.doClickCompareProductButton();
		desktopComponentSelectionPage.doClickProductContainer();
		productComparisonPage = desktopComponentSelectionPage.doClickCompareProductButtonDesktop();
	}
	
	@Test(priority = 1)
	public void doProductCompareGetDataTest() {
		productComparisonPage.getDataFromProductComparisonTable();
	}
	
	@Test(priority = 2)
	public void doClickRemoveButtonTest() {
		productComparisonPage.doClickReomveBtn();
		productComparisonPage.doClickContinueBtn();
	}

}
