package io.ctdev.pages;

import io.ctdev.SingletonDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JuiceShopLoginPage {
    private final WebDriver driver = SingletonDriver.getInstanceOfSingletonDriver();

    private By notYetCustomerLink = By.cssSelector("div#newCustomerLink a");
    private By successfulRegistrationMessage = By.xpath("//snack-bar-container[contains(.,'Registration completed successfully. You can now log in.')]");
    private By emailField = By.cssSelector("input#email");
    private By passwordField = By.cssSelector("input#password");
    private By clickLoginButton = By.cssSelector("button#loginButton");
    private By errorMessagePasswordEmailEmpty = By.cssSelector("div.error");
    private By errorMessageEmailEmpty = By.cssSelector("#login-form mat-form-field:nth-child(1) mat-error");
    private By errorMessagePasswordEmpty = By.cssSelector("#login-form mat-form-field:nth-child(2) mat-error");

    public void clickNotYetCustomerLink() {
        driver.findElement(notYetCustomerLink).click();
    }

    public void verifySuccessfulRegistrationMessageDisplayed() {
        Assert.assertTrue(!driver.findElements(successfulRegistrationMessage).isEmpty());
    }

    public void fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(clickLoginButton).click();
    }

    public void verifyErrorMessagePresent(String errorText) {
        Assert.assertTrue(driver.findElement(errorMessagePasswordEmailEmpty).isDisplayed());
        Assert.assertEquals(driver.findElement(errorMessagePasswordEmailEmpty).getText(), errorText);
    }

    public void verifyEmailErrorMessagePresent(String errorText) {
        Assert.assertTrue(driver.findElement(errorMessageEmailEmpty).isDisplayed());
        Assert.assertEquals(driver.findElement(errorMessageEmailEmpty).getText(), errorText);
    }

    public void verifyPasswordErrorMessagePresent(String errorText) {
        Assert.assertTrue(driver.findElement(errorMessagePasswordEmpty).isDisplayed());
        Assert.assertEquals(driver.findElement(errorMessagePasswordEmpty).getText(), errorText);
    }

    public void clickOnEmailField(){
        driver.findElement(emailField).click();
    }

    public void clickOnPasswordField(){
        driver.findElement(passwordField).click();
    }
}
