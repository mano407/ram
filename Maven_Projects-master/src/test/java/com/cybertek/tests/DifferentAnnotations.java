package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class DifferentAnnotations {
    WebDriver driver;
    @Test
    public void test1(){
        System.out.println("This is test one");
    }
    @BeforeMethod
    public void SetUpMethod(){
        System.out.println("Opening a browser");
        driver = new ChromeDriver();
        System.out.println("go to website and login");
        driver.get("https://google.com");

    }
    // BeforeMethod runs one time before any @Test method
    @Test
    public void test2(){
        System.out.println("This is test two");
    }
    @Test
    public void test3(){
        System.out.println("This is test three");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("logout");
        System.out.println("Closing browser");
        driver.quit();
    }
    @BeforeClass
    public void start(){
        WebDriverManager.chromedriver().setup();
        System.out.println("Setting up the drivers here");

    }
    @AfterClass
    public void End(){

        System.out.println("report everything");

    }
}
