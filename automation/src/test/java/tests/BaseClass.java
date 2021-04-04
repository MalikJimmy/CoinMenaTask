package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {


    static WebDriver driver;

    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://computer-database.herokuapp.com/computers");
        driver.manage().window().maximize();
    }

    public static WebDriver getWebDriver() {
        return driver;
    }

    public void tearDown() {
        driver.quit();
    }
}
