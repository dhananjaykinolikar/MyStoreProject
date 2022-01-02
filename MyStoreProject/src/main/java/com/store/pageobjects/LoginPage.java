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
public class LoginPage extends BaseClass {
	
	@FindBy(xpath="//input[@id='email']")
	WebElement userfild;
	
	@FindBy(xpath="//input[@id='passwd']")
	WebElement pwdfld;
	
	@FindBy(id="SubmitLogin")
	WebElement signbtn;
	
	@FindBy(xpath="//input[@id='email_create']")
	WebElement crateaccuserfld;
	
	@FindBy(id="SubmitCreate")
	WebElement createaccbtn;
	
	
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	public HomePage Login(String username, String pwd) {
		Action.type(userfild, username);
		Action.type(pwdfld, pwd);
		Action.click(getDriver(), signbtn);
		return new HomePage();
	}
	
	public AddressPage Login1(String username, String pwd) {
		Action.type(userfild, username);
		Action.type(pwdfld, pwd);
		Action.click(getDriver(), signbtn);
		return new AddressPage();
	}
	
	public AccountCreationPage createNewaccount(String username) {
		Action.type(crateaccuserfld, username);
		Action.click(getDriver(), createaccbtn);
		return new AccountCreationPage();
	}
	

	

}
