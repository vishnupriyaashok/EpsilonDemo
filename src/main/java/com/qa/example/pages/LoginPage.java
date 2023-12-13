package com.qa.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.example.utilities.ElementUtilities;



public class LoginPage {

	private WebDriver driver;
	private ElementUtilities eleUtil;
	
	By userName=By.xpath("//input[@id='user-name']");
	By password=By.xpath("//input[@id='password']");
	By loginBtn=By.xpath("//input[@id='login-button']");
	By logo=By.xpath("//div[text()='Swag Labs']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtilities(driver);
	}
	
	
	public boolean isLogoDisplayed() {
		return eleUtil.isElementPresent(logo);
	}
	
	public String  loginPagetitle() {
		return eleUtil.getPageTitle();
	}
	
	public ProductsPage doUserLogin(String un,String pwd) {
		
		eleUtil.doSendKeys(userName,un);
		eleUtil.doSendKeys(password,pwd);
		eleUtil.doClick(loginBtn);
		return new ProductsPage(driver);
		
	}
	
	public ProductsPage doLogin(String un,String pwd) {
		eleUtil.doSendKeys(userName,un);
		eleUtil.doSendKeys(password,pwd);
		eleUtil.doClick(loginBtn);
		return new ProductsPage(driver);
	}
	
}
