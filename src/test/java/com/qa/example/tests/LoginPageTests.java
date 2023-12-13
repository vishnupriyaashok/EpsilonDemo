package com.qa.example.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.example.base.BaseTest;
import com.qa.example.factory.DriverFactory;
import com.qa.example.pages.LoginPage;
import com.qa.example.utilities.Constants;
import com.qa.example.utilities.ExcelUtilities;

public class LoginPageTests extends BaseTest{

	
	@Test
	public void loginPageTittleTest() {
		String actLoginPageTitle=loginpage.loginPagetitle();
		Assert.assertEquals(actLoginPageTitle, Constants.LOGIN_PAGE_TITLE);
	}
	@Test
	public void isLogoDisplayedTest() {
		Assert.assertTrue(loginpage.isLogoDisplayed());
	}
	@Test
	public void loginTest() {
		//loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertTrue(productsPage.isProductPageHeaderExist());
	}
	
	@DataProvider
	public Object[][] getCredentialsData() {
	return ExcelUtilities.getTestData("Credentials");
	}
	
	
	@Test(dataProvider = "getCredentialsData")
	public void userLogin(String userName,String passWord) {
		productsPage = new LoginPage(df.init_driver(prop)).doUserLogin(userName, passWord);
		Assert.assertTrue(productsPage.isProductPageHeaderExist());
	}
	
}

