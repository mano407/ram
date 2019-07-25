package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ExplicitWaitExample {
    @Test
    public void test(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");

        //click on enable
        Driver.getDriver().findElement(By.xpath("//form[@id='input-example']//button")).click();
        //WebDriverWait class use to explicit wait
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        //wait.until() == this is when wait happends
        wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//input[@type='text']")));
        //enter text
        Driver.getDriver().findElement(By.xpath("//input[@type='text']")).sendKeys("hello World");
        Driver.getDriver().findElement(By.xpath("//form[@id='input-example']//button")).click();
    }
}
