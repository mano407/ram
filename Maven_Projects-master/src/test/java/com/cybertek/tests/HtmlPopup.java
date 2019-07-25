package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HtmlPopup {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }
    @Test
    public void doNotDestroyTheWorldTest() throws InterruptedException {
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//span[.='Destroy the World']")).click();
        //locate an element in the pop up window and click
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[.='No']")).click();
    }
    @Test
    public void oppsTest(){
        driver.get("https://sweetalert.js.org/");
        //trigger the pop up
        driver.findElement(By.xpath("(//button[@class='preview'])[2]")).click();
            // close the pop up
        driver.findElement(By.xpath("//button[.='OK']")).click();
    }
    @Test
    public void dismiss() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        //trigger the pop up
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();
        Thread.sleep(2000);
    }
    @Test
    public void alertText() throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/javascript_alerts");
        //trigger the pop up
        driver.findElement(By.xpath("//button[@onclick=\"jsPrompt()\"]")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("Hello");
        alert.accept();
        Thread.sleep(2000);
    }
}
