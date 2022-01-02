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
public class OrderPageTest extends BaseClass {
	

	IndexPage indexpage;
	 LoginPage LoginPage;
	HomePage HomePage;
	SearchResultPage SearchResultPage;
	AddToCartPage AddToCartPage;
	OrderPage OrderPage;
	
	@Parameters("browsername")
	@BeforeMethod (groups= {"Smoke","Sanity","Regression"})
	public void luanchApp(String browsername) {
		launchApp(browsername);
	}
		
		@AfterMethod (groups= {"Smoke","Sanity","Regression"})
		public void teardown() {
			getDriver().quit();
		}
		
		@Test(groups="Regression")
		public void verifyTotalPrice() throws Throwable {
			indexpage = new IndexPage();
			SearchResultPage=indexpage.searchfld("T-Shirt");
			AddToCartPage=SearchResultPage.clicktoProduct();
			AddToCartPage.enterQuantity("2");
			AddToCartPage.selectSize("M");
			AddToCartPage.clickOnAddToCart();
			OrderPage=AddToCartPage.clickOnCheckOut();
			
			Double Unitprice=OrderPage.getUnitPrice();
			Double Totalprice=OrderPage.getTotalPrice();
			
			Double totalExpectedPrice=(Unitprice*(Double.parseDouble("2")))+2;
			Assert.assertEquals(Totalprice, totalExpectedPrice);
		}

}
