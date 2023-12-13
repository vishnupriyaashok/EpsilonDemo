package com.qa.example.tests;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.example.base.BaseTest;
import com.qa.example.pages.ProductsPage;
import com.qa.example.utilities.Constants;
import com.qa.example.utilities.ExcelUtilities;
import com.qa.example.utilities.InventoryItem;

public class ProductPageTests extends BaseTest{
	
	@BeforeClass
	public void productPageSetUp() {
		productsPage=
				loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void productPageTitleTest() {
		String actProductsPageTitle=productsPage.getProductPageTitle();
		Assert.assertEquals(actProductsPageTitle, Constants.PRODUCT_PAGE_TITLE);
	}
	
	
	@Test
	public void productCountTest() {
		int actProductCount=productsPage.getProductCount();
		Assert.assertEquals(actProductCount, Constants.PRODUCT_COUNT);
	}
	
	@Test
	public void productInventoryListTest() {
		List<String> actInventoryList=productsPage.getInventoryList();
		System.out.println(actInventoryList);
		Assert.assertEquals(actInventoryList, Constants.PRODUCT_INVENTORY_LISTS);
	} 
	
	
	@DataProvider
	public Object[][] productlist() {
		return new Object[][] {
			{"Sauce Labs Backpack"},
				
		};
		
	}
	
	@Test(dataProvider ="productlist")
	public void productInfoTest(String product) {
		productsPage.selectProduct(product);
		
		String actProductInfoPageTitle=productInfoPage.productInfoPageTitle();
		Assert.assertEquals(actProductInfoPageTitle, Constants.PRODUCT_INFO_PAGE_TITLE);
	
	}
	
	
//	
//	@DataProvider
//	public Object[][] getInventoryData() {
	//	return ExcelUtilities.getTestData(Constants.TEST_DATA_SHEET_NAME);
//	}
//	
//	//@Test(dataProvider = "getInventoryData")
//	public void inventoryInfoTest(String Item_Name,String Item_Desc,String Item_Image,String Item_Price) {
//		System.out.println(Item_Name + "," + Item_Desc + "," + Item_Image + "," + Item_Price  );
//	

	//	Assert.assertTrue();
	//}
	
	
	
	
	
}
