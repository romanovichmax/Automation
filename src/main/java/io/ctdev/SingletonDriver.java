package io.ctdev;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class SingletonDriver {
    private static SingletonDriver instanceOfSingletonDriver = null;

    private final ThreadLocal<WebDriver> webDrivers = new ThreadLocal<>();

    private SingletonDriver() {
        switch (SystemConfig.config.driverType().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                if (SystemConfig.config.remotely()) {
                    try {
                        webDrivers.set(new RemoteWebDriver(new URL(SystemConfig.config.remoteUrl()), DesiredCapabilities.chrome()));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    webDrivers.set(new ChromeDriver());
                }
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                if (SystemConfig.config.remotely()) {
                    try {
                        webDrivers.set(new RemoteWebDriver(new URL(SystemConfig.config.remoteUrl()), DesiredCapabilities.firefox()));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    webDrivers.set(new FirefoxDriver());
                }
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();
                if (SystemConfig.config.remotely()) {
                    try {
                        webDrivers.set(new RemoteWebDriver(new URL(SystemConfig.config.remoteUrl()), DesiredCapabilities.edge()));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                } else {
                    webDrivers.set(new EdgeDriver());
                }

                break;
            default:
                System.err.println("Invalid driver type: " + SystemConfig.config.driverType().toLowerCase());
                break;
        }
        webDrivers.get().manage().window().maximize();
        webDrivers.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public static WebDriver getInstanceOfSingletonDriver() {
        if (instanceOfSingletonDriver == null) {
            instanceOfSingletonDriver = new SingletonDriver();
        }
        return instanceOfSingletonDriver.webDrivers.get();
    }
}