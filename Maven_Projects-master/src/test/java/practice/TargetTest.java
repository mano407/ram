package practice;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TargetTest {
    WebDriver driver;

    public void start(){
        System.out.println("=====Browser Session Started=====");

        driver=new ChromeDriver();

        //driver.manage().window().maximize();

        driver.get("https://www.target.com/");

        System.out.println("=====Application Started=====");
    }

    public void endTest(){
        driver.quit();
        System.out.println("=====Browser Session End=====");
    }
}
