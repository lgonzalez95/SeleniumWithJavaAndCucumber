package com.lg.steps.stepDefinitions;

import com.lg.context.TestContext;
import com.lg.constants.Endpoint;
import com.lg.factory.PageFactory;
import com.lg.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {
    private final LoginPage loginPage;
    private final SharedSteps sharedSteps;

    public LoginSteps(TestContext testContext) {
        this.loginPage = PageFactory.getLoginPage(testContext.driver);
        this.sharedSteps = new SharedSteps(testContext);
    }

    @When("I login with the username {string} and password {string}")
    public void i_login_with_the__username_and_password(String username, String password) {
        loginPage.performLogin(username, password);
    }

    @Then("I get the following login error {string}")
    public void i_get_the_following_login_error(String errorMessage) {
        Assert.assertEquals("Invalid login message", errorMessage, loginPage.getLoginErrorAlert().getText());
    }

    @Given("I'm logged in the system")
    public void i_m_logged_in_the_system() {
        sharedSteps.i_m_on_the_page(Endpoint.LOGIN.toString());
        i_login_with_the__username_and_password(System.getenv("USER_NAME"),System.getenv("USER_PASSWORD"));
    }
}