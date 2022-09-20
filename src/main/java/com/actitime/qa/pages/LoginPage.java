package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

	//Page Factory - Object Repository
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
    WebElement forgetPasswordLink;


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

    public HomePage login(String username, String pwd) {
        this.username.sendKeys(username);
        password.sendKeys(pwd);
        loginButton.click();
        return new HomePage();
    }
}
