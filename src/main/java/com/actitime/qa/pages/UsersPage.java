package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UsersPage extends TestBase  {

    @FindBy(xpath = "//*[@id=\"pageBody\"]/tbody/tr[1]/td[1]/div/span")
    WebElement userPageHeading;

    @FindBy(xpath = "//*[@id=\"editUserPanel\"]/div[1]/div/div[3]/div[1]/span")
    WebElement accountSettingHeading;

    @FindBy(xpath = "//*[@id=\"container\"]/div[12]/div[1]")
    WebElement accountInformationModal;

    @FindBy(xpath = "//*[@id=\"userListTableContainer\"]/div/table/tbody/tr[1]")
    WebElement firstUserRow;

    //initialization
    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyUserPageTitle() {
        String expTitle = "actiTIME - User List";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, expTitle);
    }

    public void verifyUserPageHeading() {
        String expTitle = "List of Users";
        String actTitle = userPageHeading.getText();
        Assert.assertEquals(actTitle, expTitle);
    }

    public UsersPage clickOnFirstUser(){
        firstUserRow.click();
        return  new UsersPage();
    }

    public void verifyAccountInformationHeadingIsVisible(){
        Assert.assertTrue(accountInformationModal.isDisplayed());
        Assert.assertEquals(accountSettingHeading.getText(), "ACCOUNT SETTINGS");
    }

}
