/**
 * 
 */
package com.mystore.testcase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;
import com.store.pageobjects.HomePage;

/**
 * @author Dhananjay
 *
 */
public class HomePageTest extends BaseClass {
	IndexPage IndexPage;
	LoginPage LoginPage;
	HomePage HomePage;
	
	@Parameters("browsername")
	@BeforeMethod (groups= {"Smoke","Sanity","Regression"})
	public void luanchApp(String browsername) {
		launchApp(browsername);
	}
	
	@AfterMethod (groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups="smoke")
	public void verifywishlist() {
		IndexPage = new IndexPage();
		LoginPage=IndexPage.clickonsign();
		HomePage=LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=HomePage.Validatewishlist();
		Assert.assertTrue(result);
		
	}
	
	@Test(groups="Smoke")
	public void verifyhistorydetails() {
		IndexPage = new IndexPage();
		LoginPage=IndexPage.clickonsign();
		HomePage=LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result=HomePage.Validatewishlist();
		HomePage.Validateorderhistorydetails();
		Assert.assertTrue(result);
	}

}
