package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {
    /*
    AutoIT: only words in windows
    Robot framwork: this is java library, works anywhere java works
    Sikuli:works on windows and unix

    In selenium, in order to upload a file:
    1, we need to locate the choose file input element
    2, Do sendKeys and send the path to the file we want to upload
     */
    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement chooseFile = driver.findElement(By.id("file-upload"));

        String path = "C:\\Users\\almir\\Downloads\\test.txt";
        chooseFile.sendKeys(path);
        Thread.sleep(2000);

        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(2000);

        Assert.assertTrue(
                driver.findElement(By.xpath("//*[.='File Uploaded!']")).isDisplayed());
    }
}
