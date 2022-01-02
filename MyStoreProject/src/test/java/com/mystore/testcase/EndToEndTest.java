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
public class EndToEndTest extends BaseClass {
	
	IndexPage indexpage;
	 LoginPage LoginPage;
	HomePage HomePage;
	SearchResultPage SearchResultPage;
	AddToCartPage AddToCartPage;
	OrderPage OrderPage;
	AddressPage AddressPage;
	ShippingPage ShippingPage;
	PaymentPage PaymentPage;
	OrderSummary OrderSummary;
	OrderConfirmationPage OrderConfirmationPage;
	
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
		public void endtoendTest() throws Throwable {
			
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
			
			
			LoginPage=OrderPage.clickOnCheckOut();
			AddressPage=LoginPage.Login1(prop.getProperty("username"), prop.getProperty("password"));
			
			ShippingPage=AddressPage.clickOnCheckOut();
			
			ShippingPage.checkTheTerms();
			PaymentPage=ShippingPage.clickOnProceedToCheckOut();
			
			OrderSummary=PaymentPage.clickOnPaymentMethod();
			
			OrderConfirmationPage=OrderSummary.clickOnconfirmOrderBtn();
			String actualMessage=OrderConfirmationPage.validateConfirmMessage();
			String expectedMsg="Your order on My Store is complete.";
			Assert.assertEquals(actualMessage, expectedMsg);
			
		}

}
