package com.qa.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.example.utilities.Constants;
import com.qa.example.utilities.ElementUtilities;

public class CartPage {
	private WebDriver driver;
	private ElementUtilities eleUtil;
	
	private By cartPageHeader=By.xpath("//div[@class='app_logo' and text()='Swag Labs']");
	private By product=By.xpath("//div[text()='Sauce Labs Backpack']");
	private By btnRemove=By.xpath("//button[@id='remove-sauce-labs-backpack']");
	private By btnCheckOut=By.xpath("//button[@id='checkout']");
	private By btncheckout=By.xpath("//button[@id='checkout']");
	
	
	

	public CartPage(WebDriver driver){
		this.driver=driver;
		eleUtil=new ElementUtilities(driver);
	}
	

	public String productIntheCart(String productName) {
		String productsInTheCart="//div[text()='" + productName+"']";
		By product=By.xpath(productsInTheCart);
		return eleUtil.waitForElementPresent(product, Constants.DEFAULT_TIME_OUT).getText();
	}
	
	
	public CustomerInfoPage clickCheckOut() {
		eleUtil.doClick(btncheckout);
		return new CustomerInfoPage(driver);
	}
	
	
	
	
}
