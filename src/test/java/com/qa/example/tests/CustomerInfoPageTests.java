package com.qa.example.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.example.base.BaseTest;
import com.qa.example.pages.LoginPage;
import com.qa.example.utilities.ExcelUtilities;

public class CustomerInfoPageTests extends BaseTest{

	@BeforeClass
	public void customerPageSetUp() {
		productsPage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	

	
	@DataProvider
	public Object[][] getProductData() {
		return new Object[][] {
			{"Sauce Labs Backpack"},
		};
	}
	
	@DataProvider
	public Object[][] getCustomerData() {
		return new Object[][] {
			{"tom","t","12345"},
		};
	}
	@Test(dataProvider ="getProductData",priority = 1)
	public void selectProduct(String product) {
		cartPage=productsPage.selectProduct(product);
		customerInfoPage=cartPage.clickCheckOut();
	}
	
	@Test(dataProvider ="getCustomerData",priority = 2)
	public void ZenterCustomerInfoTest(String fname,String lName,String postalCode)
	{
		
		customerInfoPage.enterCustomerInfo(fname, lName, postalCode);
	}
}
