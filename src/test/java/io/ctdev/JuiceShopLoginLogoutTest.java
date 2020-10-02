package io.ctdev;

import com.arakelian.faker.service.RandomData;
import io.ctdev.actions.RegistrationActions;
import io.ctdev.pages.JuiceShopHomePage;
import io.ctdev.pages.JuiceShopLoginPage;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

public class JuiceShopLoginLogoutTest extends BaseTest {

    private JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();
    private JuiceShopLoginPage juiceShopLoginPage = new JuiceShopLoginPage();

    private String email = RandomString.make() + "@test.com";
    private String password = RandomString.make(8);
    private Integer questionIndex = RandomData.get().nextInt(1, 10);
    private String answer = RandomString.make(7);

    @Test
    public void login() {
        RegistrationActions.register(email, password, questionIndex, answer);
        juiceShopLoginPage.fillEmailField(email)
                .fillPasswordField(password)
                .clickLoginButton()
                .clickAccountButton()
                .verifyLogoutButtonPresent();
        juiceShopHomePage.clickLogoutButton();
    }

    @Test(description = "Login with empty email")
    public void loginWithEmptyEmail() {
        juiceShopHomePage.closePopUps()
                .clickAccountButton()
                .clickLoginButton()
                .clickOnEmailField()
                .fillPasswordField(password)
                .verifyEmailErrorMessagePresent("Please provide an email address.");
    }

    @Test(description = "Login with empty password")
    public void loginWithEmptyPassword() {
        juiceShopHomePage.closePopUps()
                .clickAccountButton()
                .clickLoginButton()
                .clickOnPasswordField()
                .fillEmailField(email)
                .verifyPasswordErrorMessagePresent("Please provide a password.");
    }

    @Test(description = " Login Password and Email empty")
    public void loginWithEmptyEmailAndPassword() {
        juiceShopHomePage.closePopUps()
                .clickAccountButton()
                .clickLoginButton()
                .clickOnPasswordField()
                .clickOnEmailField()
                .clickOnPasswordField();
        juiceShopLoginPage.verifyPasswordErrorMessagePresent("Please provide a password.");
        juiceShopLoginPage.verifyEmailErrorMessagePresent("Please provide an email address.");
    }
}