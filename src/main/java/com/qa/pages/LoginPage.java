package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.Utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil elementUtil;
	
	
	private By iconLinkDisplay = By.xpath("//h1/a");
	private By emailId =  By.xpath("//input[@id = 'input-email']");
	private By pwd =  By.xpath("//input[@id = 'input-password']");
	private By loginBtn = By.xpath("//input[@type = 'submit']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(this.driver);
	}
	
	public String getScreenTitle() {
		return elementUtil.getTitle();
	}
	
	public boolean getDisplay() {
		return elementUtil.doIsDisplayed(iconLinkDisplay);
	}
	
	public void doLogin(String email_value,String password) {
		elementUtil.doSendKeys(emailId,email_value);
		elementUtil.doSendKeys(pwd, password);
		elementUtil.doClick(loginBtn);
	}
}
