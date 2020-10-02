package io.ctdev.actions;

import io.ctdev.pages.JuiceShopHomePage;
import io.ctdev.pages.JuiceShopLoginPage;
import io.ctdev.pages.JuiceShopRegistrationPage;

public class RegistrationActions {
    private static JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();
    private static JuiceShopLoginPage juiceShopLoginPage = new JuiceShopLoginPage();
    private static JuiceShopRegistrationPage juiceShopRegistrationPage = new JuiceShopRegistrationPage();

    public static void register(String email, String password, Integer questionIndex, String securityAnswer) {
        juiceShopHomePage.closePopUps()
                .clickAccountButton()
                .clickLoginButton()
                .clickNotYetCustomerLink()
                .fillTheEmailField(email)
                .fillThePasswordField(password)
                .fillTheRepeatPasswordField(password)
                .selectSecurityQuestion(questionIndex)
                .fillTheAnswerField(securityAnswer)
                .clickRegisterButton()
                .verifySuccessfulRegistrationMessageDisplayed();
    }
}