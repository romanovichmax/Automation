package io.ctdev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class SingletonDriver {
    private static SingletonDriver instanceOfSingletonDriver = null;

    private WebDriver driver;

    private SingletonDriver() {
        switch (SystemConfig.config.driverType().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.err.println("Invalid driver type: " + SystemConfig.config.driverType().toLowerCase());
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getInstanceOfSingletonDriver() {
        if (instanceOfSingletonDriver == null) {
            instanceOfSingletonDriver = new SingletonDriver();
        }
        return instanceOfSingletonDriver.driver;
    }
}