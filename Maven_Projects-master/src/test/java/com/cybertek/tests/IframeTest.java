package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class IframeTest {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/tinymce");
    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
    @Test
    public void switchByElement(){
        // locate the iframe
        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        // switch to iframe
        driver.switchTo().frame(iframe);
        driver.findElement(By.tagName("body")).
                sendKeys("ddeee dddedd  dd");

    }



    @Test
    public void switchById(){
        // switch to iframe
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.tagName("body")).
                sendKeys("ddeee dddedd  dd");

    }


    @Test
    public void switchByIndex(){
        // switch to iframe
        driver.switchTo().frame(0);
        driver.findElement(By.tagName("body")).
                sendKeys("ddeee dddedd  dd");

    }
    /*
    Selenium can deal with only one html document at a time

    Selenium can see iframe element, but can not what is inside it

    In order to deal with iframe, we need to change the focus of selenium
     */
}
