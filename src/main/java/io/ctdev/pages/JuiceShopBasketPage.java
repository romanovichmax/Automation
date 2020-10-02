package io.ctdev.pages;

import io.ctdev.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JuiceShopBasketPage {
    private final WebDriver driver = SingletonDriver.getInstanceOfSingletonDriver();

    private String productContainer = "//mat-row[contains(., '%s')]";

    public void verifyProductsPresent(String... products) {
        for (String product : products) {
            Assert.assertTrue(isProductPresent(product));
        }
    }

    private boolean isProductPresent(String product) {
        return !driver.findElements(By.xpath(String.format(productContainer, product))).isEmpty();
    }
}
