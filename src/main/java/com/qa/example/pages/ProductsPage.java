package com.qa.example.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.example.utilities.Constants;
import com.qa.example.utilities.ElementUtilities;
import com.qa.example.utilities.ExcelUtilities;
import com.qa.example.utilities.InventoryItem;

public class ProductsPage {
	
	private WebDriver driver;
	private ElementUtilities eleUtil;

	List<InventoryItem> listXLInventoryItem;
	List<InventoryItem> listWEInventoryItem;
	
	
	private By logo=By.xpath("//div[text()='Swag Labs']");
	//private By filterDropDownList=By.xpath("//select[@class='product_sort_container']/option");
	
	
	
    private By productsList=By.xpath("//div[@class='inventory_list']/div");
    private By inventoryList=By.xpath("//div[@class='inventory_list']//a/div");
   private By cart=By.xpath("//a[@class='shopping_cart_link']");
    
    private By byInventoryItems = By.xpath("div[@class='inventory_item']");
    private By byInventoryItemNameList=By.xpath("//div[@class='inventory_item_name']");
    private By byInventoryItemDescList=By.xpath("//div[@class='inventory_item_desc']");
    private By byInventoryItemPriceList=By.xpath("//div[@class='inventory_item_price']");
    private By byInventoryItemImageList=By.xpath("//img[@class='inventory_item_img']");
    
   private By byProductsTitle = By.xpath("//span[@class='title']");
    
    
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtilities(driver);
	}
	

	public boolean isProductPageHeaderExist() {
		return eleUtil.isElementPresent(byProductsTitle);
	}
	
	public String getProductPageTitle() {
		return eleUtil.waitForTitleIs(Constants.DEFAULT_TIME_OUT, Constants.PRODUCT_PAGE_TITLE);
		
	}
	
	
	
	public int getProductCount() {
    return eleUtil.waitForElementsToBeVisible(productsList, Constants.DEFAULT_TIME_OUT).size();
	}
	
	public List<String> getInventoryList() {
		return eleUtil.getElementsTexts(inventoryList);
	}
	

	public CartPage selectProduct(String productName ) {
		System.out.println("product name is :"+productName);
		String sAddTocart= "add-to-cart-" + productName.replace(" ", "-").toLowerCase();
		System.out.println(sAddTocart);
		By btnAddToCart=By.xpath("//button[@id='" + sAddTocart + "']");
		
		List<WebElement> productList=eleUtil.getElements(inventoryList);
	
		for(WebElement e:productList) {
			String text=e.getText();
			if(text.equalsIgnoreCase(productName)) {
				//e.click();
				break;
			}
		}
		addtoCart(btnAddToCart);
		clickOnCartpage();
		return new CartPage(driver);
		}
	
	
	
	
	public void addtoCart(By btnAddToCart ) {
		eleUtil.clickElementWhenReady(btnAddToCart,Constants.DEFAULT_TIME_OUT);
	}
	
	public void clickOnCartpage() {
		eleUtil.doClick(cart);
	}
	
	public List<InventoryItem> GetInventoryItemsFromProductsPage() {
		//System.out.println("product name is :"+productName);
		
		List<WebElement> listInventoryItems =eleUtil.getElements(byInventoryItems);
		
		List<WebElement> listInventoryItemName=eleUtil.getElements(byInventoryItemNameList);
		List<WebElement> listInventoryItemDesc=eleUtil.getElements(byInventoryItemDescList);
		List<WebElement> listInventoryItemPrice=eleUtil.getElements(byInventoryItemPriceList);
		List<WebElement> listInventoryItemImage=eleUtil.getElements(byInventoryItemImageList);
		
		listWEInventoryItem = new ArrayList<InventoryItem>() ;
		
		InventoryItem objInventoryItem;
		
		
		for (int i=0; i<listInventoryItems.size(); i++)
		{
					objInventoryItem = new InventoryItem(
					listInventoryItemName.get(i).getText(),
					listInventoryItemDesc.get(i).getText(),
					listInventoryItemImage.get(i).getText(),
					listInventoryItemPrice.get(i).getText());	
	
					listWEInventoryItem.add(objInventoryItem)	;			
		}
		
		return listWEInventoryItem;
		
		}
	
	
	public List<InventoryItem> GetInventoryItemsFromExcel() {
		
		 listXLInventoryItem = new ArrayList<InventoryItem>() ;
		
		InventoryItem objInventoryItem;
		
		Object[][] xlData = ExcelUtilities.getTestData(Constants.TEST_DATA_SHEET_NAME);
		
		
		for (int i=0; i<xlData.length; i++)
		{
					objInventoryItem = new InventoryItem(
							xlData[i][0].toString(),
							xlData[i][1].toString(),
							xlData[i][2].toString(),
							xlData[i][3].toString()
							);
					listXLInventoryItem.add(objInventoryItem)	;
		}
					
				
		return listXLInventoryItem;
		
		}
	
	
	
	public boolean ValidateContent() {
	
		return listXLInventoryItem.equals(listWEInventoryItem);
		
	}
	
	
//	
//	
//	
	
//	
//	public boolean itemValidation(String itemName, String itemDesc,  String itemImageURL, String itemPrice) {
//
//		
//		List<WebElement> listInventoryItems =eleUtil.getElements(byInventoryItems);
//		List<WebElement> listInventoryItemName=eleUtil.getElements(byInventoryItemNameList);
//		List<WebElement> listInventoryItemDesc=eleUtil.getElements(byInventoryItemDescList);
//		List<WebElement> listInventoryItemPrice=eleUtil.getElements(byInventoryItemPriceList);
//		List<WebElement> listInventoryItemImage=eleUtil.getElements(byInventoryItemImageList);
//		
//
//
////		
//		
//		eleUtil.waitForElementVisible(this.firstName, Constants.DEFAULT_TIME_OUT).sendKeys(firstName);
//		eleUtil.getElement(this.lastName).sendKeys(lastName);
//		eleUtil.getElement(this.email).sendKeys(email);
//		eleUtil.getElement(this.phone).sendKeys(phone);
//		eleUtil.getElement(this.password).sendKeys(password);
//		eleUtil.getElement(this.confirmPassword).sendKeys(password);
//		if (subscribe.equalsIgnoreCase("yes")) {
//			eleUtil.doClick(subscribeYes);
//		} else {
//			eleUtil.doClick(subscribeNo);
//		}
//		eleUtil.doClick(agreeBtn);
//		eleUtil.doClick(continueBtn);
//		
//		if (getAccountRegisterSuccessMessage().contains(Constants.REGISTER_ACCOUNT_SUCCESS_MESSAGE)) {
//			goToRegisterPage();
//			return true;
//		}
//		return false;
//
//	}
//	
	
	
	
			
		
	}
	
	
	

