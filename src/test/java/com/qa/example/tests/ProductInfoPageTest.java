package com.qa.example.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.example.base.BaseTest;
import com.qa.example.utilities.Constants;

public class ProductInfoPageTest extends BaseTest{
	
	@BeforeClass
	public void productInfoPageSetUp() {
		productsPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));	

	}
	
	
	
	@DataProvider
	public Object[][] productlist() {
		return new Object[][] {
			{"Sauce Labs Backpack"}		
		};	
	}
	
	@Test(dataProvider = "productlist")
	public void productInfoHeaderTest(String productName) {

		String actProductInfoPageTitle=productInfoPage.productInfoPageTitle();
		Assert.assertEquals(actProductInfoPageTitle, Constants.PRODUCT_INFO_PAGE_TITLE);
	}
	
	@Test
	public void isProductNameVisibleTest() {
		Assert.assertTrue(productInfoPage.isProductNameVisible());;
	}
	
	@Test
	public void isProductDesVisibleTest() {
		Assert.assertTrue(productInfoPage.isProductDesVisible());;
	}
	
	@Test
	public void isPriceVisibleTest() {
		Assert.assertTrue(productInfoPage.isPriceVisible());
	}

	@Test
	public void isAddToCartButtonVisibleTest() {
		Assert.assertTrue(productInfoPage.isAddToCartButtonVisible());;
	}
	
	@Test
	public void addingProductToCartTest() {
		productInfoPage.addingProductToCart();
		Assert.assertTrue(productInfoPage.isRemoveButtonVisible());
	}
}
