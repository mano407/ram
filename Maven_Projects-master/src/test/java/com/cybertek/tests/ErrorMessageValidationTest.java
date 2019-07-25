package com.cybertek.tests;

import com.cybertek.pages.Homepage;
import com.cybertek.pages.ListingPage;
import com.cybertek.pages.PrestashopHomePage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ErrorMessageValidationTest extends TestBase {

    @Test
    public void wrongEmailTest(){
        Homepage homepage = new Homepage();

        driver.get(ConfigurationReader.getProperty("url"));

        homepage.username.sendKeys("admin");
        homepage.password.sendKeys("test");
        homepage.loginButton.click();

        String error = "Invalid Login or Password.";
        String actualError = homepage.errorMessage.getText();

        Assert.assertEquals(actualError, error);
    }

    @Test
    public void wrongPasswordTest(){

        Homepage homepage = new Homepage();
        driver.get(ConfigurationReader.getProperty("url"));
        homepage.username.sendKeys("Tester");
        homepage.password.sendKeys("wrong password");
        homepage.loginButton.click();

        String expectedError = "Invalid Login or Password.";
        String actualError = homepage.errorMessage.getText();
        Assert.assertEquals(actualError, expectedError);

    }

    @Test
    public void blankUsername(){

        Homepage homepage = new Homepage();
        homepage.open();
        homepage.login("", "test");

        String expextedError = "Invalid Login or Password.";
        String actualError = homepage.errorMessage.getText();
        Assert.assertEquals(actualError, expextedError);
    }


    // this is just a method which does not do anything
//    @Test
//    public void test(){
//        ListingPage nilesLane = new ListingPage();
//
//        ListingPage palmetLane = new ListingPage();
//
//        PrestashopHomePage prestashopHomePage = new PrestashopHomePage();
//
//        WebElement tshirt = prestashopHomePage.product("tshirt");
//
//        WebElement dress = prestashopHomePage.product("dress");
//
//
//    }


}
