package io.ctdev.cucumber.steps;

import com.arakelian.faker.service.RandomData;
import io.ctdev.BaseTest;
import io.ctdev.pages.JuiceShopHomePage;
import io.ctdev.pages.JuiceShopLoginPage;
import io.ctdev.pages.JuiceShopRegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.bytebuddy.utility.RandomString;

public class SignUpSteps extends BaseTest {
    private JuiceShopHomePage juiceShopHomePage = new JuiceShopHomePage();
    private JuiceShopLoginPage juiceShopLoginPage = new JuiceShopLoginPage();
    private JuiceShopRegistrationPage juiceShopRegistrationPage = new JuiceShopRegistrationPage();

    private String email = RandomString.make() + "@test.com";
    private String password = RandomString.make(8);
    private Integer questionIndex = RandomData.get().nextInt(1, 10);
    private String answer = RandomString.make(7);

    @Given("User opens the Home page")
    public void openHomePage() {
        openUrl("http://3.18.213.48/#/search");
    }

    @And("User opens the Login page")
    public void userOpensTheLoginPage() {
        juiceShopHomePage.clickAccountButton();
        juiceShopHomePage.clickLoginButton();
    }

    @And("User clicks on Not yet a customer? link")
    public void userClicksOnNotYetACustomerLink() {
        juiceShopLoginPage.clickNotYetCustomerLink();
    }

    @And("User closes the popups")
    public void userClosesThePopups() {
        juiceShopHomePage.closePopUps();
    }

    @When("User fills the email field")
    public void userFillsTheEmailField() {
        juiceShopRegistrationPage.fillTheEmailField(email);
    }

    @And("User fills the password field")
    public void userFillsThePasswordField() {
        juiceShopRegistrationPage.fillThePasswordField(password);
    }

    @And("User fills the repeat password field")
    public void userFillsTheRepeatPasswordField() {
        juiceShopRegistrationPage.fillTheRepeatPasswordField(password);
    }

    @And("User selects the security question")
    public void userSelectsTheSecurityQuestion() {
        juiceShopRegistrationPage.selectSecurityQuestion(questionIndex);
    }

    @And("User fills the answer field")
    public void userFillsTheAnswerField() {
        juiceShopRegistrationPage.fillTheAnswerField(answer);
    }

    @And("User clicks on register button")
    public void userClicksOnRegisterButton() {
        juiceShopRegistrationPage.clickRegisterButton();
    }

    @Then("User should see the Successful registration message")
    public void userShouldSeeTheSuccessfulRegistrationMessage() {
        juiceShopLoginPage.verifySuccessfulRegistrationMessageDisplayed();
    }
}
