package com.lg.steps.stepDefinitions;

import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.CartPage;

public class SharedStepsFunctions {
    private final CartPage cartPage;

    public SharedStepsFunctions(TestContext testContext) {
        this.cartPage = PageFactory.getCartPage(testContext.driver);
    }

    public void handleButtonsForCartPage(String buttonName) {
        switch (buttonName) {
            case "CHECKOUT" -> cartPage.proceedToCheckoutPage();
        }
    }
}
