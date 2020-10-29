package io.ctdev.actions;

import io.ctdev.pages.JuiceShopHomePage;

public class RegistrationActions {
    private static JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();

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