package io.ctdev;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver = SingletonDriver.getInstanceOfSingletonDriver();

    public void openUrl(String url) {
        driver.get(url);
    }

    @BeforeClass
    public void setup() {
        openUrl("http://3.18.213.48/#/register");
    }

    @AfterMethod
    public void deleteCookies() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @AfterTest
    public void closeDriver() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
