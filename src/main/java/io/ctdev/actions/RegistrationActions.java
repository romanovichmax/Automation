package io.ctdev.actions;

import io.ctdev.BaseTest;
import io.ctdev.pages.JuiceShopHomePage;
import io.ctdev.pages.JuiceShopLoginPage;
import io.ctdev.pages.JuiceShopRegistrationPage;

public class RegistrationActions {
    private static JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();
    private static JuiceShopLoginPage juiceShopLoginPage = new JuiceShopLoginPage();
    private static JuiceShopRegistrationPage juiceShopRegistrationPage = new JuiceShopRegistrationPage();

    public static void register(String email, String password,Integer questionIndex, String securityAnswer) {
        juiceShopHomePage.clickDismissButton();
        juiceShopHomePage.clickAccountButton();
        juiceShopHomePage.clickLoginButton();
        juiceShopLoginPage.clickNotYetCustomerLink();
        juiceShopRegistrationPage.fillTheEmailField(email);
        juiceShopRegistrationPage.fillThePasswordField(password);
        juiceShopRegistrationPage.fillTheRepeatPasswordField(password);
        juiceShopRegistrationPage.selectSecurityQuestion(questionIndex);
        juiceShopRegistrationPage.fillTheAnswerField(securityAnswer);
        juiceShopRegistrationPage.clickRegisterButton();
        juiceShopLoginPage.verifySuccessfulRegistrationMessageDisplayed();
    }
}