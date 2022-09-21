package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LeaveManagementPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"leaveTimePlanningPage\"]/tbody/tr[1]/td/div/span[2]/a")
    WebElement leaveRequestLink;

    @FindBy(xpath = "//*[@id=\"contentInnerDiv\"]/div")
    WebElement leaveManagementHeading;


    public LeaveManagementPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyPageTitle(){
        String expTitle = "actiPLANS - Leave Time Chart";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, expTitle);
    }

    public void verifyLeaveManagementPageLoaded(){
        Assert.assertTrue(leaveManagementHeading.isDisplayed(),"Page Loading Failed!");
    }

    public LeaveRequestPage clickLeaveRequestLink(){
        leaveRequestLink.click();
        return new LeaveRequestPage();
    }

}
