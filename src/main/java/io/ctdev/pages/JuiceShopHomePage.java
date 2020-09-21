package io.ctdev.pages;

import io.ctdev.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JuiceShopHomePage {
    private final WebDriver driver = SingletonDriver.getInstanceOfSingletonDriver();

    private By dismissButtonCss = By.cssSelector("button[aria-label='Close Welcome Banner']");
    private By accountButtonCss = By.cssSelector("button#navbarAccount");
    private By loginButtonCss = By.cssSelector("button#navbarLoginButton");
    private By logoutButtonCss = By.cssSelector("button#navbarLogoutButton");
    private By logoutbutton = By.cssSelector("button#navbarLogoutButton");

    public void clickDismissButton() {
        if (!driver.findElements(dismissButtonCss).isEmpty())
            driver.findElement(dismissButtonCss).click();
    }

    public void clickAccountButton() {

        driver.findElement(accountButtonCss).click();
    }

    public void clickLoginButton() {
        driver.findElement(loginButtonCss).click();
    }

    public void verifyLogoutButtonPresent() {
        driver.findElement(logoutButtonCss).isDisplayed();
    }
    public void clickLogoutButton(){
        driver.findElement(logoutButtonCss).click();
    }
}
