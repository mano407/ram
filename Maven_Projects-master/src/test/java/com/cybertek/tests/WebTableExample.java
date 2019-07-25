package com.cybertek.tests;

import com.cybertek.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableExample extends TestBase {

    @Test
    public void printWholeTable() throws InterruptedException {
        login();
        WebElement table = driver.findElement(By.id("ctl00_MainContent_orderGrid"));
        System.out.println(table.getText());
    }
    public void login() throws InterruptedException {
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).
                sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).
                sendKeys("test"+ Keys.ENTER);
        Thread.sleep(2000);
    }
    @Test
    public void printAllHeaders() throws InterruptedException {
        login();
        List<WebElement> headers = driver.findElements(
                By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[1]")
        );
        for(WebElement header : headers){
            System.out.println(header.getText());
        }

    }

    @Test
    public void printRow() throws InterruptedException {
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr"));
        System.out.println("number of rows: " + allRows.size());


        for (WebElement header : allRows) {
            System.out.println(header.getText());
        }


        System.out.println("printing row " + 4);


        System.out.println(allRows.get(3).getText());
    }
    @Test
    public void printTableSize() throws InterruptedException {
        login();
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        System.out.println("Number of rowa: "+ allRows.size());
        List<WebElement> allCols =  allRows.get(1).findElements(By.tagName("td"));
        System.out.println("Number of cols: "+ allCols.size());

    }
    //print a row without using a list
    @Test
    public void printRow2() throws InterruptedException {
        login();
        WebElement row = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[5]"));
        System.out.println(row.getText());
    }
    //print all the cells as a row index is given in the xpath
    @Test
    public void printAllCellsInOneRaw() throws InterruptedException {
        login();
        List<WebElement> cells = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[2]/td"));

        for(WebElement header : cells){
            System.out.println(header.getText());
        }
    }
    //print by coordination, based on row and colume number
    @Test
    public void printByCoordination() throws InterruptedException {
        login();
        WebElement cell = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr[6]/td[11]"));
        System.out.println(cell.getText());
    }
    public WebElement getCell(int row, int col){
        String xpath = "//table[@id='ctl00_MainContent_orderGrid']/tbody/tr["+row+"]/td["+col+"]";
        return driver.findElement(By.xpath(xpath));
    }

    //print all the values in single column

    @Test
    public void printColumn() throws InterruptedException{
        login();
        List<WebElement> allNames = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']/tbody/tr/td[3]"));

        for(WebElement header : allNames){
            System.out.println(header.getText());
        }
    }
    @Test
    public void selectCheckBox() throws InterruptedException {
        login();
        WebElement checkBox = driver.findElement(By.xpath("//td[.='Susan McLaren']/../td[1]/input"));
        System.out.println(checkBox.isSelected());
        checkBox.click();
        System.out.println(checkBox.isSelected());
    }
    // verify that "name" exits in the names column, Verify that City exits in City colume
    @Test
    public void test() throws InterruptedException {
        login();
        int nameIndex = getColumnIndex("Product");
        System.out.println(nameIndex);
    }

    private int getColumnIndex(String column) {
        List<WebElement> allHeader = driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        for(int i=0; i<allHeader.size();i++){
            if(allHeader.get(i).getText().equals(column)){
                return i+1;
            }
        }
        return 0;
    }
}
