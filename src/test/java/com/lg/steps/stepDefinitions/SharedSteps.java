package com.lg.steps.stepDefinitions;

import com.lg.constants.Endpoint;
import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SharedSteps {
    BasePage basePage;
    SharedStepsFunctions sharedStepsFunctions;

    public SharedSteps(TestContext testContext, SharedStepsFunctions sharedStepsFunctions) {
        this.basePage = PageFactory.getBasePage(testContext.driver);
        this.sharedStepsFunctions = sharedStepsFunctions;
    }

    @Given("I'm on the {string} page")
    public void i_m_on_the_page(String pageName) {
        basePage.load(Endpoint.valueOf(pageName).url);
    }

    @Then("I'm taken to the {string} page")
    public void i_m_taken_to_the_page(String expectedUrl) {
        String pageUrl = basePage.getCurrentPageUrl();
        Assert.assertTrue(expectedUrl + " should be contained in " + pageUrl, pageUrl.contains(expectedUrl));
    }

    @When("I click the {string} button of the {string} page")
    public void i_click_the_button_of_the_page(String buttonName, String pageWhereButtonIsLocated) {
        switch (Endpoint.valueOf(pageWhereButtonIsLocated)) {
            case CART -> sharedStepsFunctions.handleButtonsForCartPage(buttonName);
        }
    }
}
