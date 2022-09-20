package com.actitime.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.actitime.qa.base.TestBase;

import net.bytebuddy.asm.Advice.Return;

public class LoginPage extends TestBase {

	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	WebElement username;

	@FindBy(xpath = "//input[@type='password'and @name='pwd']")
	WebElement password;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='remember']")
	WebElement keepmeLoggedinCheckBox;
	
	@FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
	WebElement forgotYourPasswordLink;
	
	
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;
	
	
	//initialization
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action/Methods
	
	public Boolean validateActiTimeLogo() {
		return actiTimeLogo.isDisplayed();
	}
	
	public HomePage loging(String uName, String pword) {
		username.sendKeys(uName);
		password.sendKeys(pword);
		loginButton.click();
		return new HomePage();
	}
}
