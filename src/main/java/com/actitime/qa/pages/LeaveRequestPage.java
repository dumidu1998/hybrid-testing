package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import com.actitime.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LeaveRequestPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"requestsTableContainer\"]/table")
    WebElement requestTable;

    @FindBy(xpath = "//*[@id=\"ext-gen24\"]")
    WebElement statusFilter;

    @FindBy(xpath = "//*[@id=\"corporateScheduleTable\"]/tbody/tr[1]/td/span/span[2]")
    WebElement approveBtn;

    @FindBy(xpath = "//*[@id=\"corporateScheduleTable\"]/tbody/tr[1]/td/span/span[3]")
    WebElement rejectBtn;

    @FindBy(xpath = "//*[@id=\"rejectDialogDiv\"]/textarea")
    WebElement rejectReason;

    @FindBy(xpath = "//*[@id=\"rejectDialogDiv\"]/div[2]/div[1]")
    WebElement rejectSubmitBtn;





    public LeaveRequestPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyPageTitle(){
        String expTitle = "actiPLANS - Leave Time Requests";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, expTitle);
    }

    public void verifyRequestTableLoaded(){
        Assert.assertTrue(requestTable.isDisplayed(),"Table Not Loaded!");
    }


    public void filterByStatus(String status) {
        statusFilter.click();
        driver.findElement(By.linkText(status)).click();
    }

    public void checkRequests(int n) {
        List<WebElement> checkboxes = driver.findElements(By.className("applicableLabel"));
        for(int i=0; i<n; i++)
        {
            checkboxes.get(i).click();
        }
    }

    public void approveSelected(int n) throws InterruptedException {
        approveBtn.click();
        Thread.sleep(5000);
        List<WebElement> statusList = driver.findElements(By.className("statusText"));
        for(int i=0; i<n; i++){
            Assert.assertEquals(statusList.get(i).getText(),"Approved");
        }
    }

    public void rejectSelected(int n) throws InterruptedException {
        rejectBtn.click();
        rejectReason.sendKeys("automated Run");
        rejectSubmitBtn.click();
        Thread.sleep(5000);
        List<WebElement> statusList = driver.findElements(By.className("statusText"));
        for(int i=0; i<n; i++){
            Assert.assertEquals(statusList.get(i).getText(),"Rejected");
        }
    }
}
