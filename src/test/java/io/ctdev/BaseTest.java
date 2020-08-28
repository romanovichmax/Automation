package io.ctdev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class BaseTest {
    private static WebDriver driver = getDriver();

    public static WebDriver getDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\webdrivers\\chromedriver.exe");
        if (driver == null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void openUrl(String url) {
        getDriver().get(url);
    }

    @AfterTest
    public void closeDriver() {
        getDriver().quit();
    }

    public String getTitle() {
        return getDriver().getTitle();
    }
}
