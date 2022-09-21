package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiPlanHomePage extends TestBase {

    @FindBy(xpath = "//*[@id=\"topnav\"]/tbody/tr/td[4]/a")
    WebElement leaveManagementLink;



    @FindBy(xpath = "//*[@id=\"welcomeScreenLightbox_content\"]")
    WebElement modal;

    @FindBy(xpath = "//*[@id=\"welcomeScreenLightbox_content\"]/table/tbody/tr/td/div[1]")
    WebElement modalCloseBtn;

    public ActiPlanHomePage() {
        PageFactory.initElements(driver, this);
    }

    public LeaveManagementPage clickLeaveManagement() throws InterruptedException {
        Thread.sleep(5000);
        if (!driver.findElements(By.xpath("//*[@id=\"welcomeScreenLightbox_content\"]")).isEmpty()) {
            modalCloseBtn.click();
        }
        leaveManagementLink.click();
        return new LeaveManagementPage();
    }
}
