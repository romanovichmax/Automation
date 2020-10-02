package io.ctdev.pages;

import io.ctdev.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class JuiceShopHomePage {
    private final WebDriver driver = SingletonDriver.getInstanceOfSingletonDriver();

    private By dismissButtonCss = By.cssSelector("button[aria-label='Close Welcome Banner']");
    private By accountButtonCss = By.cssSelector("button#navbarAccount");
    private By loginButtonCss = By.cssSelector("button#navbarLoginButton");
    private By logoutButtonCss = By.cssSelector("button#navbarLogoutButton");
    private By logoButton = By.cssSelector("button[aria-label='Back to homepage']");
    private By basketButton = By.cssSelector("button[routerlink='/basket']");
    private By addedToBasketPopUp = By.cssSelector("simple-snack-bar");
    private By nextPageButton = By.cssSelector("button.mat-paginator-navigation-next");
    private By addToBasketSoldOut = By.xpath("//mat-card[.//div[contains(@class, 'ribbon-sold')]]//button");
    private By soldOutErrorMessage = By.xpath("//simple-snack-bar[contains(.,'We are out of stock! Sorry for the inconvenience.')]");
    private By meWantItButton = By.cssSelector("a[aria-label='dismiss cookie message']");

    private String addToBasketButton = "//mat-card[contains(.,'%s')]//button";
    private String productContainer = "//div[@mattooltip='Click for more information'][contains(., '%s')]";

    public JuiceShopHomePage selectProducts(String... products) {
        final WebDriverWait wait = new WebDriverWait(driver, 10);
        for (String product : products) {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(addToBasketButton, product))));
            driver.findElement(By.xpath(String.format(addToBasketButton, product))).click();
            wait.until(ExpectedConditions.presenceOfElementLocated(addedToBasketPopUp));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(addedToBasketPopUp));
        }
        return this;
    }

    public JuiceShopHomePage closePopUps() {
        if (!driver.findElements(dismissButtonCss).isEmpty())
            driver.findElement(dismissButtonCss).click();
        if (!driver.findElements(meWantItButton).isEmpty())
            driver.findElement(meWantItButton).click();
        return this;
    }

    public JuiceShopHomePage clickAccountButton() {
        driver.findElement(accountButtonCss).click();
        return this;
    }

    public JuiceShopLoginPage clickLoginButton() {
        driver.findElement(loginButtonCss).click();
        return new JuiceShopLoginPage();
    }

    public void verifyLogoutButtonPresent() {
        Assert.assertTrue(driver.findElement(logoutButtonCss).isDisplayed());
    }

    public JuiceShopHomePage clickLogoutButton() {
        driver.findElement(logoutButtonCss).click();
        return this;
    }

    public JuiceShopHomePage clickLogoButton() {
        driver.findElement(logoButton).click();
        return this;
    }

    public JuiceShopHomePage refresh() {
        driver.navigate().refresh();
        return this;
    }

    public JuiceShopBasketPage clickBasketButton() {
        driver.findElement(basketButton).click();
        return new JuiceShopBasketPage();
    }

    public JuiceShopProductDetailsPage openProductDetailsPage(String product) {
        driver.findElement(By.xpath(String.format(productContainer, product))).click();
        return new JuiceShopProductDetailsPage();
    }

    public JuiceShopHomePage paginateNextPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(nextPageButton));
        driver.findElement(nextPageButton).click();
        wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        return this;
    }

    public JuiceShopHomePage clickOnAddToBasketButtonSoldOutItem() {
        driver.findElement(addToBasketSoldOut).click();
        return this;
    }

    public void isSoldOutErrorMessagePresent() {
        Assert.assertFalse(driver.findElements(soldOutErrorMessage).isEmpty());
    }
}
