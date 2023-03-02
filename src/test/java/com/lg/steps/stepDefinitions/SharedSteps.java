package com.lg.steps.stepDefinitions;

import com.lg.constants.Endpoint;
import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.BasePage;
import io.cucumber.java.en.Given;

public class SharedSteps {
    BasePage basePage;

    public SharedSteps(TestContext testContext) {
        this.basePage = PageFactory.getBasePage(testContext.driver);
    }

    @Given("I'm on the {string} page")
    public void i_m_on_the_page(String pageName) {
        basePage.load(Endpoint.valueOf(pageName).url);
    }
}
