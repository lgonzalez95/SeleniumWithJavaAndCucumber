package com.lg.steps.stepDefinitions;

import com.lg.constants.Endpoint;
import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.AddEmployeePage;
import io.cucumber.java.en.Given;

public class SharedSteps {
    AddEmployeePage addEmployeePage;
    public SharedSteps(TestContext testContext) {
        this.addEmployeePage = PageFactory.getAddEmployeePage(testContext.driver);
    }

    @Given("I'm on the {string} page")
    public void i_m_on_the_page(String pageName) {
        addEmployeePage.load(Endpoint.valueOf(pageName).url);
    }
}
