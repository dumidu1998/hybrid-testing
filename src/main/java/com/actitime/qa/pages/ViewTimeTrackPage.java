package com.actitime.qa.pages;

import com.actitime.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class ViewTimeTrackPage extends TestBase {

    @FindBy(xpath = "//*[@id=\"viewTTContent\"]/table/tbody/tr/td[2]/table/tbody/tr/td[2]")
    WebElement userDropDown;

    @FindBy(xpath = "//*[@id=\"viewTTDetailsTableContainer\"]/div/div[1]")
    WebElement timeTrackDetailsTopic;

    public ViewTimeTrackPage() {
        PageFactory.initElements(driver, this);
    }


    public void verifyPageTitle(){
        String expTitle = "actiTIME - View Time-Track";
        String actTitle = driver.getTitle();
        Assert.assertEquals(actTitle, expTitle);
    }

    public void selectRandomUser() throws InterruptedException {
        userDropDown.click();
        List<WebElement> users = driver.findElements(By.className("userName"));
        int random = (int)(Math.random()*(5-1+1)+1);
        users.get(random).click();
        Thread.sleep(5000);
        String topic = timeTrackDetailsTopic.getText();
        Assert.assertEquals(topic,"Time-Track Details");
    }
}
