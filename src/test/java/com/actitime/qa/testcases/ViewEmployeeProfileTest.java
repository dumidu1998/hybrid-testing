package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.UsersPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ViewEmployeeProfileTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    UsersPage usersPage;

    public ViewEmployeeProfileTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        usersPage = homePage.clickOnUsersLink();
    }

    @Test(priority = 1)
    public void userPageLoaded() {
        usersPage.verifyUserPageTitle();
        usersPage.verifyUserPageHeading();
    }

    @Test(priority = 2)
    public void ClickOnUser() {
        usersPage = usersPage.clickOnFirstUser();
        usersPage.verifyAccountInformationHeadingIsVisible();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
