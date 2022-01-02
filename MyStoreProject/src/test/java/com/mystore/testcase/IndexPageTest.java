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

/**
 * @author Dhananjay
 *
 */
public class IndexPageTest extends BaseClass {
	IndexPage indexpage;
	
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
	public void verifylogo() {
		indexpage = new IndexPage();
		boolean result=indexpage.validatelogo();
		Assert.assertTrue(result);
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		String actpagetitle=getDriver().getTitle();
		System.out.println(actpagetitle);
		//String actpagetitle=indexpage.PageTitle();
		Assert.assertEquals(actpagetitle, "My Store1");
	}

}
