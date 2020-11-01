package io.ctdev.pages;

import io.ctdev.SingletonDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JuiceShopRegistrationPage {
    private final WebDriver driver = SingletonDriver.getInstanceOfSingletonDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, 5);

    private By emailField = By.cssSelector("input#emailControl");
    private By passwordField = By.cssSelector("input#passwordControl");
    private By repeatPasswordField = By.cssSelector("input#repeatPasswordControl");
    private By securityQuestionDropdown = By.cssSelector("div#registration-form div.security-container mat-form-field:nth-child(1)");
    private By answerField = By.cssSelector("input#securityAnswerControl");
    private By registerButton = By.cssSelector("button#registerButton");

    @Step
    public JuiceShopRegistrationPage fillTheEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    @Step
    public JuiceShopRegistrationPage fillThePasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }

    @Step
    public JuiceShopRegistrationPage fillTheRepeatPasswordField(String repeatPassword) {
        driver.findElement(repeatPasswordField).sendKeys(repeatPassword);
        return this;
    }

    @Step
    public JuiceShopRegistrationPage selectSecurityQuestion(int index) {
        driver.findElement(securityQuestionDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(String.format("[id^=mat-option]:nth-child(%s)", index))));
        driver.findElement(By.cssSelector(String.format("[id^=mat-option]:nth-child(%s)", index))).click();
        return this;
    }

    @Step
    public JuiceShopRegistrationPage fillTheAnswerField(String answer) {
        driver.findElement(answerField).sendKeys(answer);
        return this;
    }

    @Step
    public JuiceShopLoginPage clickRegisterButton() {
        driver.findElement(registerButton).click();
        return new JuiceShopLoginPage();
    }
}