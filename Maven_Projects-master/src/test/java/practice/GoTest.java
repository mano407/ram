package practice;

public class GoTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\almir\\Documents\\Selenium dependenceies\\drivers\\chromedriver.exe");

        ChildTest t1 = new ChildTest();
        t1.AddToCart(t1.Search());
        t1.DeleteItem();
    }
}
