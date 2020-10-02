package io.ctdev;

import com.arakelian.faker.service.RandomData;
import io.ctdev.actions.LoginActions;
import io.ctdev.actions.RegistrationActions;
import io.ctdev.pages.JuiceShopHomePage;
import io.ctdev.pages.JuiceShopProductDetailsPage;
import net.bytebuddy.utility.RandomString;
import org.testng.annotations.Test;

public class VerifyInfoAboutProduct extends BaseTest {
    private JuiceShopProductDetailsPage productDetailsPage = new JuiceShopProductDetailsPage();
    private JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();

    private String email = RandomString.make() + "@test.com";
    private String password = RandomString.make(8);
    private Integer questionIndex = RandomData.get().nextInt(1, 10);
    private String answer = RandomString.make(7);

    @Test
    public void verifyInfoAboutProduct() {
        RegistrationActions.register(email, password, questionIndex, answer);
        LoginActions.login(email, password);
        juiceShopHomePage.openProductDetailsPage("Banana Juice");
        productDetailsPage.verifyTitle("Banana Juice (1000ml)");
        productDetailsPage.verifyDescription("Monkeys love it the most.");
    }
}
