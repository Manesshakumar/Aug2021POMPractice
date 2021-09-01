package com.qa.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;

public class DesktopComponentSelectionPageTest extends BaseTest{
	
	@BeforeClass
	public void doLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage = productInfoPage.doHomeBtnClick();
		desktopComponentSelectionPage = homePage.hoverOnSelectionDesktop();
	}
	
	@Test(priority = 1)
	public void doDesktopProdSelectionTest() {
		desktopComponentSelectionPage.getDesktopCategorySelection();
	}
	
	@Test(priority = 2)
	public void doCompareBtnClickTest() {
		desktopComponentSelectionPage.doClickCompareProductButton();
	}
	@Test(priority = 3)
	public void doContainerClickTest() {
		desktopComponentSelectionPage.doClickProductContainer();
}
	@Test(priority = 4)
	public void doProductComapreBtnClickTest() {
		desktopComponentSelectionPage.doClickCompareProductButtonDesktop();
	}
}
