package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class HomePage extends TestBase {

    //Page Factory - Object Repository
    @FindBy(xpath = "//a[@class='content tasks']")
    WebElement taskLink;

    @FindBy(xpath = "//a[@class='content reports']")
    WebElement reportsLink;

    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actitimeLogo;

    @FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr[1]/td[2]/div/a")
    WebElement switchToActiPlans;

    @FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr[1]/td[6]/a")
    WebElement usersLink;

    @FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr[2]/td[2]/div[2]/a")
    WebElement viewTimeTrackLink;

    @FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr[2]/td[2]/div[4]/a")
    WebElement approveTimeSheetLink;


    //initialization
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Action/Methods
    public Boolean validateActiTimeLogo() {
        return actitimeLogo.isDisplayed();
    }

    public void verifyHomePageTitle() {
        String expTitle = "actiTIME - Enter Time-Track";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, expTitle);
    }


    public ApproveTimeSheetPage clickOnApproveTimeSheetLink() {
        approveTimeSheetLink.click();
        return new ApproveTimeSheetPage();
    }

    public ViewTimeTrackPage clickOnViewTimeTrackLink() {
        viewTimeTrackLink.click();
        return new ViewTimeTrackPage();
    }

    public UsersPage clickOnUsersLink() {
        usersLink.click();
        return new UsersPage();
    }

    public ActiPlanHomePage clickOnSwitchToActiPlans() {
        switchToActiPlans.click();
        return new ActiPlanHomePage();
    }

}
