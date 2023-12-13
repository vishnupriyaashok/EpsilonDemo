package com.qa.example.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.example.exceptions.DriverException;
import com.qa.example.exceptions.FrameworkException;
import com.qa.example.utilities.Browser;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public static String highlight;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	public WebDriver init_driver(Properties prop) {
		String browserName=prop.getProperty("browser").trim();
		System.out.println("browser value is : "+browserName);
		highlight=prop.getProperty("highlight").trim();
		
		if (browserName.equalsIgnoreCase(Browser.CHROME_BROWSER_VALUE)) {
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase(Browser.FIREFOX_BROWSER_VALUE)) {
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase(Browser.SAFARI_BROWSER_VALUE)) {
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browserName);
			throw new DriverException("browser is not correct..."  + browserName);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
		
	}
	
	
	public static  WebDriver getDriver() {
		return tlDriver.get();
	}
	
	
	public Properties init_prop() {

		prop = new Properties();
		FileInputStream ip = null;
		String envName = System.getProperty("env");
		System.out.println("Running tests on environment: " + envName);
		
		if (envName == null) {
			System.out.println("No env is given....hence running it on QA");
		
			try {
				ip = new FileInputStream("C:\\AK\\TEK\\Projects\\EpsilonDemo\\src\\test\\resources\\config\\config.properties");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}

		else {
			try {
				switch (envName.toLowerCase().trim()) {
				case "qa":
					ip = new FileInputStream("");
					break;
				case "stage":
					ip = new FileInputStream("");
				case "dev":
					ip = new FileInputStream("");
					break;
				case "uat":
					ip = new FileInputStream("");
					break;
				case "prod":
					ip = new FileInputStream("");
					break;

				default:
					System.out.println("please pass the right environment....." + envName);
					
					throw new FrameworkException("environment name is not valid..." + envName);
					
				}
			} catch (Exception e) {

			}

		}

		try {
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;

	}

	/**
	 * take screenshot
	 */
	public static String getScreenshot() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshot/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

	
}
