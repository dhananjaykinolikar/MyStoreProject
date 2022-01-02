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
public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexpage;
	 LoginPage LoginPage;
	HomePage HomePage;
	SearchResultPage SearchResultPage;
	
	@Parameters("browsername")
	@BeforeMethod (groups= {"Smoke","Sanity","Regression"})
	public void luanchApp(String browsername) {
		launchApp(browsername);
	}
		
		@AfterMethod (groups= {"Smoke","Sanity","Regression"})
		public void teardown() {
			getDriver().quit();
		}
		
		@Test(groups="Smoke")
		public void  productAvailabilityTest() {
			indexpage= new IndexPage();
			SearchResultPage=indexpage.searchfld("T-Shirt");
			boolean result=SearchResultPage.validateProductavailable();
				Assert.assertTrue(result);
			}
		}
		


