package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ApproveTimeSheetPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"container\"]/table/tbody/tr/td/div[1]/table/tbody/tr/td[1]")
    WebElement approveTimeTrackHeading;

    @FindBy(xpath = "//*[@id=\"statusFilterButton\"]")
    WebElement filter;

    @FindBy(xpath = "//*[@id=\"notReadyForApprovalCbx\"]")
    WebElement notReadyCheckBox;

    @FindBy(xpath = "//*[@id=\"rejectedCbx\"]")
    WebElement rejectCheckBox;

    @FindBy(xpath = "/html/body/div[12]/div[3]/div/button[1]")
    WebElement applyFilterButton;

    @FindBy(xpath = "//*[@id=\"approveTTTable\"]/tbody[2]/tr[1]/td[7]/input")
    WebElement firstCheckBox;

    @FindBy(xpath = "//*[@id=\"approveButton\"]")
    WebElement approveBtn;

    @FindBy(xpath = "//*[@id=\"rejectButton\"]")
    WebElement rejectBtn;

    @FindBy(xpath = "//*[@id=\"approveTTTable\"]/tbody[2]/tr[1]/td[6]/a")
    WebElement revokeText;



    public ApproveTimeSheetPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyPageTitle(){
        String expTitle = "actiTIME - Approve Time-Track";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, expTitle);
    }

    public void verifyPageLoaded(){
        Assert.assertTrue(approveTimeTrackHeading.isDisplayed(),"Page Loading Failed!");
    }


    public void viewPendingTimeSheets() {
        filter.click();
        notReadyCheckBox.click();
        rejectCheckBox.click();
        applyFilterButton.click();
    }

    public void selectFirstTimeSheet() {
        firstCheckBox.click();
    }

    public void approveSelected() throws InterruptedException {
        approveBtn.click();
        Thread.sleep(1000);
        Assert.assertEquals(revokeText.getText(),"revoke");
    }

    public void rejectSelected() throws InterruptedException {
        rejectBtn.click();
        Thread.sleep(1000);
        Assert.assertEquals(revokeText.getText(),"revoke");
    }
}
