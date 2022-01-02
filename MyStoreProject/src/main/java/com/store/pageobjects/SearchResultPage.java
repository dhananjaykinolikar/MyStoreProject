package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	WebElement productresult;
	
	
	 public SearchResultPage() {
		 PageFactory.initElements(getDriver(), this);
	 }
	
		public boolean  validateProductavailable() {
			return Action.isDisplayed(getDriver(), productresult);
		}
		
		public AddToCartPage clicktoProduct() {
			Action.click(getDriver(), productresult);
			return new AddToCartPage();
		}

}
