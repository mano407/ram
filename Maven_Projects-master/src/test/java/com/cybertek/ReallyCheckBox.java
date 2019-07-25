package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ReallyCheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // time out
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        WebElement monday = driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));
        System.out.println("Is checkbox selected? "+monday.isSelected());
//        System.out.println("click!");
//        monday.click();
//        System.out.println("Is checkbox selected? "+monday.isSelected());
        if(!monday.isSelected()){
            monday.click();
        }else{
            System.out.println("Monday is selected!");
        }
    }
}
