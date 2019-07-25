package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitTow {

    @Test
    public void test() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //click on a button
        Driver.getDriver().findElement(By.tagName("button")).click();
       // Thread.sleep(10000);
        //locate text
        WebElement text = Driver.getDriver().findElement(By.cssSelector("#finish h4"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(
                ExpectedConditions.visibilityOf(text)
        );
        System.out.println(text.getText());
        //verify text is displayed
        Assert.assertTrue(text.isDisplayed());

    }
}
