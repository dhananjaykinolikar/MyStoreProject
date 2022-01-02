package com.store.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	@FindBy(xpath="//a[contains(text(),'Sign in')]")
	WebElement siginbtn;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement searchfld;
	
	@FindBy(xpath="//img[@class='logo img-responsive']") 
	//@FindBy(xpath="//*[@id=\"header_logo\"]/a/img")
	WebElement mystorelogo;
	
	@FindBy(xpath="//button[@name=\"submit_search\"]")
	WebElement searchbtn;
	
	public IndexPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public LoginPage clickonsign() {
		Action.fluentWait(getDriver(), siginbtn, 10);
		Action.click(getDriver(), siginbtn);
		
		return new LoginPage();
	}
	
	public boolean validatelogo() {
		Action.fluentWait(getDriver(), mystorelogo, 10);
		return Action.isDisplayed(getDriver(), mystorelogo);
	}
	
	public String  PageTitle() {
		String titlename= getDriver().getTitle();
		return titlename;
	}
	
	public SearchResultPage searchfld(String productname) {
		Action.type(searchfld, productname);
		Action.click(getDriver(), searchbtn);
		
		return new SearchResultPage();
	}

}
