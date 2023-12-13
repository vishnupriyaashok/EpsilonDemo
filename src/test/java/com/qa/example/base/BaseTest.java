package com.qa.example.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.example.factory.DriverFactory;
import com.qa.example.pages.CartPage;
import com.qa.example.pages.CustomerInfoPage;
import com.qa.example.pages.LoginPage;
import com.qa.example.pages.ProductInfoPage;
import com.qa.example.pages.ProductsPage;


public class BaseTest {
	protected DriverFactory df;
	protected Properties prop;
	protected WebDriver driver;
	protected LoginPage loginpage;
	protected ProductsPage productsPage;
	protected ProductInfoPage productInfoPage;
	protected CartPage cartPage;
	protected CustomerInfoPage customerInfoPage;
	
	@BeforeTest
	@Parameters({"browser"})
	public void setUp( String browser) {

		df = new DriverFactory();
		prop = df.init_prop();

		if (browser != null) {
			prop.setProperty("browser", browser);	
		}

		driver = df.init_driver(prop);
		loginpage = new LoginPage(driver);
		productsPage=new ProductsPage(driver);
		productInfoPage=new ProductInfoPage(driver);
		cartPage=new CartPage(driver);
		customerInfoPage=new CustomerInfoPage(driver);
	}

	//@AfterTest
	public void tearDown() {
		driver.quit();
	}
	
}
