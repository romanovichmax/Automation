package io.ctdev.pages;

import io.ctdev.SingletonDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    private By successfulMessage = By.xpath("//*[contains(text(),'Registration completed successfully')]");

    @Step("Click not yet customer link")
    public JuiceShopRegistrationPage clickNotYetCustomerLink() {
        driver.findElement(notYetCustomerLink).click();
        return new JuiceShopRegistrationPage();
    }

    public void verifySuccessfulRegistrationMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(successfulMessage)).isDisplayed());
    }

    @Step("Fill in the email field")
    public JuiceShopLoginPage fillEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step("fill in the password field")
    public JuiceShopLoginPage fillPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step("Click on Login button")
    public JuiceShopHomePage clickLoginButton() {
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(clickLoginButton));
        driver.findElement(clickLoginButton).click();
        return new JuiceShopHomePage();
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

    @Step("Click email field")
    public JuiceShopLoginPage clickOnEmailField() {
        driver.findElement(emailField).click();
        return this;
    }

    @Step("Click on password field")
    public JuiceShopLoginPage clickOnPasswordField() {
        driver.findElement(passwordField).click();
        return this;
    }
}
