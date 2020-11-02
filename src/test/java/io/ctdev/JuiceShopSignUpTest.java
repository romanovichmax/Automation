package io.ctdev;

import com.arakelian.faker.service.RandomData;
import io.ctdev.pages.JuiceShopHomePage;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

public class JuiceShopSignUpTest extends BaseTest {
    private JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();

    private String email = RandomString.make() + "@test.com";
    private String password = RandomString.make(8);
    private Integer questionIndex = RandomData.get().nextInt(1, 10);
    private String answer = RandomString.make(7);

    @Test
    public void juiceShopRegistrationTest() {
        juiceShopHomePage.closePopUps()
                .clickAccountButton()
                .clickLoginButton()
                .clickNotYetCustomerLink()
                .fillTheEmailField(email)
                .fillThePasswordField(password)
                .fillTheRepeatPasswordField(password)
                .selectSecurityQuestion(questionIndex)
                .fillTheAnswerField(answer)
                .clickRegisterButton()
                .verifySuccessfulRegistrationMessageDisplayed();
        juiceShopHomePage.clickLogoutButton();
    }
}
