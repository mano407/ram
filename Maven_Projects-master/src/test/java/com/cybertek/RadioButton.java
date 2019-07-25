package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // time out
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");

        WebElement blue=driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red=driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));
        //verify if checked
        System.out.println("Blue "+blue.isSelected());
        System.out.println("Red "+red.isSelected());
        blue.click();
        System.out.println("===clicked blue");
        System.out.println("Blue "+blue.isSelected());
        red.click();
        System.out.println("===clicked red");
        System.out.println("Blue "+blue.isSelected());
        System.out.println("Red "+red.isSelected());

        System.out.println("football "+driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input")).isSelected());
    }

}
