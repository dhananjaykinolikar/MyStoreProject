/**
 * 
 */
package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Dhananjay
 *
 */
public class HomePage extends BaseClass {
	
 @FindBy(xpath="//span[contains(text(),'My wishlists')]")
 WebElement Whishlistbtn;
 
 @FindBy(xpath="//span[contains(text(),'Order history and details')]")
 WebElement OrderHistoryDetails;
 
 
 public HomePage() {
	 PageFactory.initElements(getDriver(), this);
 }
 
 public boolean Validatewishlist() {
	 return Action.isDisplayed(getDriver(), Whishlistbtn);
 }
 
 public boolean Validateorderhistorydetails() {
	 return Action.isDisplayed(getDriver(), OrderHistoryDetails);
 }
 
 public String homepagecurrenturl() {
	 String homepageurl= Action.getCurrentURL(getDriver());
	 
	 return homepageurl;
 }
 

}
