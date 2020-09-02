package io.ctdev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SingletonDriver {
    private static SingletonDriver instanceOfSingletonDriver = null;

    private final WebDriver driver;

    public SingletonDriver() {
        System.setProperty("webdriver.chrome.driver", SystemConfig.config.driverPath());
        driver = new ChromeDriver();
    }

    public static SingletonDriver getInstanceOfSingletonDriver() {
        if (instanceOfSingletonDriver == null) {
            instanceOfSingletonDriver = new SingletonDriver();
        }
        return instanceOfSingletonDriver;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
