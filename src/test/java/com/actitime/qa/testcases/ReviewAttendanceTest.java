package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.pages.ViewTimeTrackPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReviewAttendanceTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ViewTimeTrackPage viewTimeTrackPage;

    public ReviewAttendanceTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
        viewTimeTrackPage = homePage.clickOnViewTimeTrackLink();

    }


    @Test(priority = 1)
    public void viewTimeTrackPageLoaded() {
        viewTimeTrackPage.verifyPageTitle();
    }

    @Test(priority = 2)
    public void viewTimeTrackOfaUser() throws InterruptedException {
        viewTimeTrackPage.selectRandomUser();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
