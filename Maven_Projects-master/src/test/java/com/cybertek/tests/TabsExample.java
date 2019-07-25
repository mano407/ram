package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabsExample {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/windows");
    }
    @AfterMethod
    public void cleanUp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test
    public void changeTab(){
        System.out.println(driver.getWindowHandles().size());

      driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getWindowHandles().size());

        //change to the new tab
        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println("*****************");
        for(String handle : windowHandles){
            System.out.println(handle);
            driver.switchTo().window(handle);
            System.out.println(driver.getTitle());
            if (driver.getTitle().equals("New Window")){
                break;
            }
        }
      Assert.assertEquals(driver.getTitle(),"New Window");
    }
    @Test
    public void changeTabs2(){
        driver.navigate().to("https://www.w3schools.com/html/");
        driver.findElement(By.linkText("Try it Yourself »")).click();
        //title of the second tryit Editor v3.6
        //get all handles
        //switch one by one
        //if the title is right, break the loop

        for(String handle: driver.getWindowHandles()){
            driver.switchTo().window(handle);
             if(driver.getTitle().equals("Tryit Editor v3.6")){
                 break;
             }
        }
        Assert.assertTrue(driver.getCurrentUrl().contains("default"));

        System.out.println(driver.getWindowHandles().size());
        driver.close();
        System.out.println(driver.getWindowHandles().size());
    }
}
