package com.qa.Test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.Utils.Constants;
import com.qa.base.BaseTest;



public class ComponentPageTest extends BaseTest {

	@BeforeClass
	public void doLogin() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 0)
	public void doClickOnComponentEleTest() {
		componentPage.doHoverComponentElement("Monitors");
	}



	@Test(priority = 1)
	public void doScreenTitleCheck() {
		String screenComptitle = componentPage.screenTransitionTitleCheck();
		Assert.assertEquals("Monitors", screenComptitle);
	}
	
	@Test(priority = 2)
	public void doProductItemsTest() {
		List<String> productList = componentPage.getproductItems();
		Assert.assertEquals(Constants.componentMonitorProductlist(), productList);
	}
	
	@Test(priority = 3)
	public void doProductSelectTest() {
		componentPage.doProductselection("Samsung SyncMaster 941BW");
	}
}