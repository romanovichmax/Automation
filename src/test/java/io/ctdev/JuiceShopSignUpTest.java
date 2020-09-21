package io.ctdev;

import com.arakelian.faker.service.RandomData;
import io.ctdev.pages.JuiceShopHomePage;
import io.ctdev.pages.JuiceShopLoginPage;
import io.ctdev.pages.JuiceShopRegistrationPage;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

public class JuiceShopSignUpTest extends BaseTest {
    private JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();
    private JuiceShopLoginPage juiceShopLoginPage = new JuiceShopLoginPage();
    private JuiceShopRegistrationPage juiceShopRegistrationPage = new JuiceShopRegistrationPage();

    private String email = RandomString.make() + "@test.com";
    private String password = RandomString.make(8);
    private Integer questionIndex = RandomData.get().nextInt(1, 10);
    private String answer = RandomString.make(7);

    @Test
    public void juiceShopRegistrationTest() {
        juiceShopHomePage.clickDismissButton();
        juiceShopHomePage.clickAccountButton();
        juiceShopHomePage.clickLoginButton();
        juiceShopLoginPage.clickNotYetCustomerLink();
        juiceShopRegistrationPage.fillTheEmailField(email);
        juiceShopRegistrationPage.fillThePasswordField(password);
        juiceShopRegistrationPage.fillTheRepeatPasswordField(password);
        juiceShopRegistrationPage.selectSecurityQuestion(questionIndex);
        juiceShopRegistrationPage.fillTheAnswerField(answer);
        juiceShopRegistrationPage.clickRegisterButton();
        juiceShopLoginPage.verifySuccessfulRegistrationMessageDisplayed();
    }
}
