package com.qa.example.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.example.base.BaseTest;

public class CartPageTests extends BaseTest {

	@BeforeClass

	public void cartpageSetUp() {
		productsPage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));

	}
	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Sauce Labs Backpack"},
		};
	}
	

	@Test(dataProvider = "getProductData")
	public void productIntheCartTest(String productName) {
		cartPage=productsPage.selectProduct(productName);
		String actProductName=cartPage.productIntheCart(productName);
		
		Assert.assertEquals(actProductName, "Sauce Labs Backpack");
		customerInfoPage=cartPage.clickCheckOut();
		
	}
	
	
	

}
