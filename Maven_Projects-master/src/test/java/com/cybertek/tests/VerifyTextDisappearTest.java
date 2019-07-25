package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyTextDisappearTest extends TestBase {


    @Test
    public void verify1(){
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");
        WebElement text = driver.findElement(By.id("myDIV"));
        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//button[.='Toggle Hide and Show']"));
        button.click();

        Assert.assertFalse(text.isDisplayed());
    }

    @Test
    public void verify2(){
        driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_html_remove");
        //switch iframe
        driver.switchTo().frame("iframeResult");
        WebElement text = driver.findElement(By.xpath("//body/p"));

        Assert.assertTrue(text.isDisplayed());

        WebElement button = driver.findElement(By.xpath("//body/button"));
        button.click();

        Assert.assertTrue(!elementDisaplyed(By.xpath("//body/p")));

    }
    /*
       takes a locator and return if element matching this locator exists
       @param by
       @return
        */
    public boolean elementDisaplyed(By by){
        try{
            return driver.findElement(by).isDisplayed();
        }catch (NoSuchElementException e){
            return false;
        }

    }

    public boolean elementDisaplayeds(By by){
        return driver.findElements(by).isEmpty();
    }
}
