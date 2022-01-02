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
import com.store.pageobjects.*;


/**
 * @author Dhananjay
 *
 */
public class AccountCreationPageTest extends BaseClass {
	
	IndexPage IndexPage;
	LoginPage LoginPage;
	HomePage HomePage;
	AccountCreationPage AccountCreationPage;
	
	@Parameters("browsername")
	@BeforeMethod (groups= {"Smoke","Sanity","Regression"})
	public void luanchApp(String browsername) {
		launchApp(browsername);
	}
	
	@AfterMethod (groups= {"Smoke","Sanity","Regression"})
	public void teardown() {
		getDriver().quit();
	}
	
	@Test(groups="Snity")
	public void validateaccountpage()  {
		IndexPage = new IndexPage();
		LoginPage=IndexPage.clickonsign();
		AccountCreationPage=LoginPage.createNewaccount(prop.getProperty("createaccountusername"));
		boolean result=AccountCreationPage.validateaccountpage();
		Assert.assertTrue(result);
		
		
	}

}
