package com.qa.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;


public class LoginPageTest extends BaseTest {
	
	
	@Test(priority = 1)
	public void doScreenTitleTest() {
		String screenTile = loginPage.getScreenTitle();
		Assert.assertEquals("Account Login",screenTile );
	}
	
	
	@Test(priority = 2)
	public void doIconDisplayTest() {
		Assert.assertTrue(loginPage.getDisplay());
	}
	
	@Test(priority = 3)
	public void doLoginTest() {
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

}
