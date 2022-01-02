package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.store.utility.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	//public static WebDriver driver;
	
	// Declare ThreadLocal Driver
		public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();
		
		public static WebDriver getDriver() {
			// Get Driver from threadLocalmap
			return driver.get();
		}
		
		@BeforeSuite (groups= {"Smoke","Sanity","Regression"})
		public void loadConfig() {
			ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		
		prop = new Properties();
		System.out.println("Super constructed invoke");
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("driver" + driver);
		}
	/*
	@BeforeTest (groups= {"Smoke","Sanity","Regression"})
	public void loadconfig() {
		
		prop = new Properties();
		System.out.println("Super constructed invoke");
		FileInputStream ip;
		try {
			ip = new FileInputStream(System.getProperty("user.dir") + "\\Configuration\\config.properties");
			prop.load(ip);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		System.out.println("driver" + driver);

	}*/
	

	
	public  static void launchApp(String browsername) {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.iedriver().setup();
		
		//String browsername= prop.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome")) {
			//driver = new ChromeDriver();
			
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
			
		}if(browsername.equalsIgnoreCase("IE")) {
			//driver = new InternetExplorerDriver();
			
			driver.set(new InternetExplorerDriver());
		}else {
			//driver = new ChromeDriver();
			
			// Set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());
		}
		
		//Action.implicitWait(driver, 20);
		getDriver().manage().timeouts().implicitlyWait
		(Integer.parseInt(prop.getProperty("implicitWait")),TimeUnit.SECONDS);
		
		
		//Action.pageLoadTimeOut(driver, 30);
		getDriver().manage().timeouts().pageLoadTimeout
		(Integer.parseInt(prop.getProperty("pageLoadTimeOut")),TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		getDriver().manage().window().maximize();
		
		//driver.manage().deleteAllCookies();
		getDriver().manage().deleteAllCookies();
		
		//driver.get(prop.getProperty("url"));
		getDriver().get(prop.getProperty("url"));
		
		
		
	}
	
	@AfterSuite(groups = { "Smoke", "Regression","Sanity" })
	public void afterSuite() {
		ExtentManager.endReport();
	}
	

}
