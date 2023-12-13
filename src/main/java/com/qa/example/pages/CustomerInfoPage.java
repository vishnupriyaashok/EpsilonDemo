package com.qa.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;

import com.qa.example.utilities.Constants;
import com.qa.example.utilities.ElementUtilities;
import com.qa.example.utilities.JavaScriptUtilities;

public class CustomerInfoPage {
	private WebDriver driver;
	private ElementUtilities eleUtil;
	private JavaScriptUtilities jsUtil;
	
	private By firstName=By.xpath("//input[@id='first-name']");
	private By btnContinue =By.xpath("//input[@id='continue']"); 
	//input[@id='continue']
	private By lastName=By.xpath("//input[@id='last-name']");
	private By postalCode=By.xpath("//input[@id='postal-code']");
	private By btnFinish=By.xpath("//button[@id='finish']");
	
	String idFN="first-name";
	String idLN="last-name";
	String idPc="postal-code";
	


	public CustomerInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtilities(driver);
		jsUtil=new JavaScriptUtilities(driver);
	}
	
	
	
	public void enterCustomerInfo(String fName,String lName,String Zipcode) {
		
		eleUtil.doActionsSendKeys(firstName, fName); //
		eleUtil.doActionsSendKeys(lastName, lName); //
		eleUtil.doActionsSendKeys(postalCode,Zipcode);
	//jsUtil.sendKeysUsingWithId(idFN,fName);
//		jsUtil.sendKeysUsingWithId(idLN,lName);
//		jsUtil.sendKeysUsingWithId(idPc,Zipcode);
		clickContinue();

		eleUtil.doActionsClick(btnFinish);
	}
	

	public void clickContinue() {
		eleUtil.doClick(btnContinue);
	}

}
