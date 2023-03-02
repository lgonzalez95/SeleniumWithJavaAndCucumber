package com.lg.steps.stepDefinitions;

import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.DashboardPage;
import com.lg.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class DashboardSteps {
    private final DashboardPage dashboardPage;
    private final LoginPage loginPage;

    public DashboardSteps(TestContext testContext) {
        this.dashboardPage = PageFactory.getDashboardPage(testContext.driver);
        this.loginPage = PageFactory.getLoginPage(testContext.driver);
    }

    @When("I log out from the system")
    public void i_log_out_from_the_system() {
        dashboardPage.logout();
    }

    @Then("I'm taken to the login page")
    public void i_m_taken_to_the_login_page() {
        Assert.assertTrue("The user was logout successfully", loginPage.getLoginFormContainer().isDisplayed());
    }
}
