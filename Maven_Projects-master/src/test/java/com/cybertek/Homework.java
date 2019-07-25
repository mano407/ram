package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Homework {
    public static void main(String[] args) {

        Sports();

    }
    public static void Sports(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton");
        System.out.println("Verify the default radio button");
        if(driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input")).isSelected()){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL - Football not selected");
        }
        System.out.println("Verify other options not selected");
        driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input")).click();
        List<WebElement> options = new ArrayList<WebElement>();
        options = driver.findElements(By.className("gwt-RadioButton"));

        for(int i =0; i<options.size();i++){
            System.out.println(options.get(i).getText());
        }

    }
}
