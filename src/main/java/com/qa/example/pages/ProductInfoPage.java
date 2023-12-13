package com.qa.example.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.example.utilities.Constants;
import com.qa.example.utilities.ElementUtilities;

public class ProductInfoPage 
{
	private WebDriver driver;
	private ElementUtilities eleUtil;
	
	private By productHeader=By.xpath("//div[@class='inventory_details_desc_container']");
	private By productDescription=By.xpath("//div[@class='inventory_details_desc large_size']");
	private By productPrice=By.xpath("//div[@class='inventory_details_price']");
	private By btnAddToCart=By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']");
	private By btnRemove=By.xpath("//button[@id='remove-sauce-labs-backpack']");
	private By linkShoppingCart=By.xpath("//a[@class='shopping_cart_link']");
	private By inventoryList=By.xpath("//div[@class='inventory_list']//a/div");
	 
	public ProductInfoPage(WebDriver driver){
		this.driver=driver;
		eleUtil=new ElementUtilities(driver);
	}
	
	public String productInfoPageTitle() {
		
		return eleUtil.getPageTitle();
	}
	

	
	
	public boolean isProductNameVisible() {
		WebElement header=eleUtil.waitForElementVisible(productHeader,Constants.DEFAULT_TIME_OUT);
		return header.isDisplayed();
	}
	
	public boolean isProductDesVisible() {
		return eleUtil.doIsElementDisplayed(productDescription);
	}
	
	public boolean isPriceVisible() {
		return eleUtil.doIsElementDisplayed(productPrice);
	}
	
	public boolean isAddToCartButtonVisible() {
		return eleUtil.doIsElementDisplayed(btnAddToCart);
	}
	
	public void addingProductToCart() {
		eleUtil.doClick(btnAddToCart);
	}
	
	public boolean isRemoveButtonVisible() {
		return eleUtil.doIsElementDisplayed(btnRemove);
	}
	
    public CartPage verifyTheProductInCart() {	
		addingProductToCart();
		eleUtil.doClick(linkShoppingCart);
		return new CartPage(driver);
	}
	
	

}
