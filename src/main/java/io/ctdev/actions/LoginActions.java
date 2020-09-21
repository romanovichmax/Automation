package io.ctdev.actions;

import io.ctdev.pages.JuiceShopHomePage;
import io.ctdev.pages.JuiceShopLoginPage;

public class LoginActions {
    private static JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();
    private static JuiceShopLoginPage juiceShopLoginPage = new JuiceShopLoginPage();

    public static void login(String email, String password) {
        juiceShopLoginPage.fillEmailField(email);
        juiceShopLoginPage.fillPasswordField(password);
        juiceShopLoginPage.clickLoginButton();
        juiceShopHomePage.clickAccountButton();
        juiceShopHomePage.verifyLogoutButtonPresent();
    }

    public static void logout(){
        juiceShopHomePage.clickAccountButton();
        juiceShopHomePage.clickLogoutButton();
    }
}
