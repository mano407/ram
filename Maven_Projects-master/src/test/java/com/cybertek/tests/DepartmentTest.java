package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DepartmentTest {
    WebDriver driver;
    Select allDepartment;
    @BeforeClass
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
       driver.get("http://amazon.com");
    }
    @Test(priority = 0)
    public void test(){
        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
    //create a Select class object
        allDepartment = new Select(selectElement);
        //get the current selected option
        String selectedOption = allDepartment.getFirstSelectedOption().getText();
        //TODO skipping because failing
        Assert.assertEquals(selectedOption,"All");

    }
    @Test(priority = 1)
    public void sortAlphabetical(){
//     for(WebElement option : allDepartment.getOptions()){
//            System.out.println(option.getText());
//     }
        for(int i=1; i<allDepartment.getOptions().size()-1;i++){
            String current = allDepartment.getOptions().get(i).getText();
            String next = allDepartment.getOptions().get(i+1).getText();
            System.out.println("comparing: "+current+
                   " with "+ next);
            Assert.assertTrue(current.compareTo(next)<=0);

        }
    }
    @Test
    public void mainDepartmentTest() throws InterruptedException {
        //        5.Click on the menu icon on the left

        driver.findElement(By.cssSelector("i.hm-icon.nav-sprite")).click();

        // click on Full Store directory
        // waiting because it is taking time for element to load and be clickable
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a[href='/gp/site-directory?ref_=nav_em_T1_0_2_2_33__fullstore']")).click();

        // capture all of the main department names in the page.

        List<WebElement> mainDepts = driver.findElements(By.cssSelector("h2.fsdDeptTitle"));

        for (WebElement option :
                mainDepts) {
            System.out.println(option.getText());
        }
    }
    @AfterClass
    public void end(){
        driver.quit();
    }
}
