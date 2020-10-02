package io.ctdev.pages;

import io.ctdev.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JuiceShopProductDetailsPage {
    private final WebDriver driver = SingletonDriver.getInstanceOfSingletonDriver();

    private By titleCss = By.cssSelector("mat-dialog-content h1");
    private By descriptionCss = By.cssSelector(".mat-dialog-content > div > div:nth-of-type(1) > div:nth-of-type(2) > div:nth-of-type(1)");

    public void verifyTitle(String title) {
        Assert.assertTrue(driver.findElement(titleCss).getText().contains(title));
    }

    public void verifyDescription(String description) {
        Assert.assertTrue(driver.findElement(descriptionCss).getText().contains(description));
    }
}
