package io.ctdev.actions;

import io.ctdev.pages.JuiceShopHomePage;

public class LogoutActions {
    private static JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();

    public static void logout() {
        juiceShopHomePage.clickAccountButton()
                .clickLogoutButton();
    }
}
