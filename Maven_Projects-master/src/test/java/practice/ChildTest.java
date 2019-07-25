package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class ChildTest extends TargetTest {
    public boolean Search() throws InterruptedException {
        start();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[7]/div/div/ul/li[14]/a")).click();
        System.out.println("current URL: "+driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[4]/div/div/ul/li[2]/a")).click();
        String result = driver.getCurrentUrl();
        System.out.println("Testing if correct URL:");
        if(result.toLowerCase().contains("coffee")){
            System.out.println("PASS");
            return true;
        }else{
            System.out.println("FAIL");
            return false;
        }
    }
    public void AddToCart(boolean pass) throws InterruptedException {
       if(pass){
           driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
           System.out.println("current URL is: "+driver.getCurrentUrl());
            driver.findElement(By.cssSelector("#mainContainer > div:nth-child(8) > div > div > div.h-margin-a-default.h-margin-t-tiny.Row-fhyc8j-0.gOdoOA > div.sc-htoDjs.hDVFrt.Col-lvtw7q-0.bUbvTg > div > ul > li:nth-child(3) > div > div.styles__StyledProductCardBody-ytfmhe-3.kigeoZ.ProductCardBody-xd75tz-0.ewQOJf > div > div > div > div.styles__ATCButtonWrapper-ytfmhe-0.hGCIoC > div.DetailsButtons-sc-1ytv2h5-0.iWjkDz > div > div > button")).click();
           Thread.sleep(2000);
           System.out.println("=== Verify the add to cart message ===");
           String PopText = driver.findElement(By.xpath("/html/body/div[14]/div/div/div/div[1]/div[2]/h2")).getText();
           if(PopText.equals("Added to cart")){
               System.out.println("PASS -- Showed added to cart message");
           }else{
               System.out.println("FAIL");
           }
           Thread.sleep(2000);
           System.out.println("=== Checking the cart ===");

           driver.findElement(By.xpath("/html/body/div[14]/div/div/button")).click();
           Thread.sleep(1000);
           if(driver.getCurrentUrl().toLowerCase().contains("cart")){
               System.out.println("PASS == Correct URL");
           }else{
               System.out.println("FAIL == Wrong URL");
           }
           WebElement quantity = driver.findElement(By.className("cartLinkQuantity"));
           System.out.println("Number of items in cart: "+quantity.getText());
       }else{
           System.out.println("Can't find page");
       }

       endTest();
    }
    public void DeleteItem() throws InterruptedException{
        start();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println("Searching item");
        driver.findElement(By.id("search")).sendKeys("fossil"+ Keys.ENTER);
        System.out.println("Adding item");
        driver.findElement(By.xpath("//*[@id=\"mainContainer\"]/div[3]/div/div/div[1]/div[3]/div/ul/li[2]/div/div[2]/div/div/div/div[5]/div[1]/div/div/button")).click();
        String PopText = driver.findElement(By.xpath("/html/body/div[13]/div/div/div/div[1]/div[2]/h2")).getText();
        if(PopText.equals("Added to cart")){
            System.out.println("PASS -- Showed added to cart message");
        }else{
            System.out.println("FAIL");
        }
        driver.findElement(By.xpath("/html/body/div[20]/div/div/div/div[3]/div[3]/button")).click();
        WebElement quantity = driver.findElement(By.className("cartLinkQuantity"));
        System.out.println("Number of items in cart: "+quantity.getText());
        //Check out the cart icon
        driver.findElement(By.id("cart")).click();
        System.out.println("Removing item");
        driver.findElement(By.xpath("//*[@id=\"cart-container\"]/div[1]/div[1]/div[5]/div/div/div/button")).click();
        WebElement message = driver.findElement(By.cssSelector("#cart-container > div > div.h-padding-a-default > div.h-margin-a-tight > div > div:nth-child(2) > h1"));
        if(message.getText().equals("Your cart is empty")){
            System.out.println("PASS==item removed");
        }else{
            System.out.println("FAIL");
            System.out.println(message.getText());
        }
      //endTest();
    }
}
