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

    public LoginSteps(TestContext testContext) {
        this.loginPage = PageFactory.getLoginPage(testContext.driver);
    }

    @When("I login with the username {string} and password {string}")
    public void i_login_with_the__username_and_password(String username, String password) {
        if(username.equals("SYSTEM_USER") && password.equals("SYSTEM_PASSWORD"))
            loginPage.performLogin(System.getenv("SYSTEM_USER"),System.getenv("SYSTEM_PASSWORD"));
        else
            loginPage.performLogin(username, password);
    }

    @Then("I get the following login error {string}")
    public void i_get_the_following_login_error(String errorMessage) throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertEquals("Invalid login message", errorMessage, loginPage.getLoginErrorAlert().getText());
    }
}