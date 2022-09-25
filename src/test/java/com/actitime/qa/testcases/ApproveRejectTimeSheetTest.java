package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.ApproveTimeSheetPage;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApproveRejectTimeSheetTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ApproveTimeSheetPage approveTimeSheetPage;

    public ApproveRejectTimeSheetTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        approveTimeSheetPage = homePage.clickOnApproveTimeSheetLink();

    }


    @Test(priority = 1)
    public void viewTimeTrackPageLoaded() {
        approveTimeSheetPage.verifyPageTitle();
        approveTimeSheetPage.verifyPageLoaded();
    }

    @Test(priority = 1)
    public void approveTimeTrack() throws InterruptedException {
        approveTimeSheetPage.viewPendingTimeSheets();
        approveTimeSheetPage.selectFirstTimeSheet();
        approveTimeSheetPage.approveSelected();
    }

    @Test(priority = 1)
    public void rejectTimeTrack() throws InterruptedException {
        approveTimeSheetPage.viewPendingTimeSheets();
        approveTimeSheetPage.selectFirstTimeSheet();
        approveTimeSheetPage.rejectSelected();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
