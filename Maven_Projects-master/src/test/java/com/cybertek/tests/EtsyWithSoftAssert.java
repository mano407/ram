package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EtsyWithSoftAssert extends TestBase {

    @Test
    public void test(){

        driver.get("http://etsy.com");
        driver.findElement(By.id("search-query")).sendKeys("gift"+ Keys.ENTER);

        softAssert.assertTrue(driver.getTitle().toLowerCase().contains("gift"));
        System.out.println(driver.getTitle());

    }

}
