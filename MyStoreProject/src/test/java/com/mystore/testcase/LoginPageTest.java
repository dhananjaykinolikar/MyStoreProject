/**
 * 
 */
package com.mystore.testcase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.store.pageobjects.IndexPage;
import com.store.pageobjects.LoginPage;
import com.store.utility.Log;
import com.store.pageobjects.HomePage;

/**
 * @author Dhananjay
 *
 */
public class LoginPageTest extends BaseClass {

IndexPage indexpage;
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
	
	@Test (dataProvider="credentials", dataProviderClass=DataProviders.class, groups={"Smoke","Sanity"})
	public void LoginPage(String user, String pwd) {
		Log.startTestCase("LoginPage");
		indexpage = new IndexPage();
		LoginPage=indexpage.clickonsign();
		Log.info("Inserting user and password");
		//HomePage=LoginPage.Login(prop.getProperty("username"), prop.getProperty("password"));
		HomePage=LoginPage.Login(user, pwd);
		String acthomepageurl=HomePage.homepagecurrenturl();
		Log.endTestCase("LoginPage");
		
		
	}
}
