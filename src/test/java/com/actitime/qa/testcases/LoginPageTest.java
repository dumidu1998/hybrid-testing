package com.actitime.qa.testcases;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.pages.HomePage;
import com.actitime.qa.pages.LoginPage;
import com.actitime.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

    LoginPage loginPage;
    HomePage homePage;
    String sheetName = "Users";
    TestUtil testUtil;

    public LoginPageTest() {
        super();
    }


    @BeforeMethod
    public void setup() {
        initialization();
        loginPage = new LoginPage();
    }


    @Test(priority = 1)
    public void loginPageLogoTest() {
        boolean flag = loginPage.validateActiTimeLogo();
        Assert.assertTrue(flag);
    }


    @DataProvider
    public Object[][] getActiTimeTestData() {
        Object[][] data = TestUtil.getTestData(sheetName);
        return data;
    }

    @Test(priority = 2, dataProvider = "getActiTimeTestData")
    public void LoginTest(String userName, String password) {
        homePage = loginPage.login(userName, password);
        homePage.validateActiTimeLogo();
        homePage.verifyHomePageTitle();
    }

    @Test(priority = 2)
    public void invalidLogin(){
        loginPage.login("test", "test");
        loginPage.invalidLoginTextVisible();
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
