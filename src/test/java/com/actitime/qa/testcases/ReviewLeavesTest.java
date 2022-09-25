package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.*;
import com.actitime.qa.util.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ReviewLeavesTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    ActiPlanHomePage actiPlanHomePage;
    LeaveManagementPage leaveManagementPage;
    LeaveRequestPage leaveRequestPage;

    public ReviewLeavesTest() {
        super();
    }

    @BeforeMethod
    public void setup() throws InterruptedException {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        actiPlanHomePage = homePage.clickOnSwitchToActiPlans();
        leaveManagementPage = actiPlanHomePage.clickLeaveManagement();
    }

    @Test(priority = 1)
    public void leaveManagementPageLoaded() {
        leaveManagementPage.verifyPageTitle();
        leaveManagementPage.verifyLeaveManagementPageLoaded();
    }

    @Test(priority = 1)
    public void leaveRequestPageLoaded() {
        leaveRequestPage = leaveManagementPage.clickLeaveRequestLink();
        leaveRequestPage.verifyPageTitle();
        leaveRequestPage.verifyRequestTableLoaded();
    }

    @Test(priority = 1)
    public void approveLeaveRequests() throws InterruptedException, IOException {
        leaveRequestPage = leaveManagementPage.clickLeaveRequestLink();
        leaveRequestPage.filterByStatus("Waiting for Approval");
        leaveRequestPage.checkRequests(2);
        leaveRequestPage.approveSelected(2);
        TestUtil.takeScreenshot();
    }

    @Test(priority = 1)
    public void rejectLeaveRequests() throws InterruptedException, IOException {
        leaveRequestPage = leaveManagementPage.clickLeaveRequestLink();
        leaveRequestPage.filterByStatus("Waiting for Approval");
        leaveRequestPage.checkRequests(2);
        leaveRequestPage.rejectSelected(2);
        TestUtil.takeScreenshot();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
