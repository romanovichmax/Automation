package io.ctdev;

import org.testng.annotations.AfterTest;

public class BaseTest {
    SingletonDriver singletonDriver = new SingletonDriver();

    public void openUrl(String url) {
       singletonDriver.getDriver().get(url);
    }

    @AfterTest
    public void closeDriver() {
        singletonDriver.getDriver().quit();
    }

    public String getTitle() {
        return singletonDriver.getDriver().getTitle();
    }
}
