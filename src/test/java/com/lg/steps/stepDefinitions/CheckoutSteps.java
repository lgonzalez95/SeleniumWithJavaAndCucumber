package com.lg.steps.stepDefinitions;

import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.models.BillingDetails;
import com.lg.pages.CheckoutPage;
import com.lg.utils.ModelMapperUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class CheckoutSteps {
    private CheckoutPage checkoutPage;
    private ModelMapperUtility modelMapperUtility;

    public CheckoutSteps(TestContext testContext, ModelMapperUtility modelMapperUtility) {
        this.checkoutPage = PageFactory.getCheckoutPage(testContext.driver);
        this.modelMapperUtility = modelMapperUtility;
    }

    @When("I continue my checkout as a {string}")
    public void i_continue_my_checkout_as_a(String checkoutOption) {
        if (checkoutOption.equals("Register Account"))
            checkoutPage.continueCheckoutAsRegisteredAccount();
        else
            checkoutPage.continueCheckoutAsGuest();
    }

    @When("I enter the following billing details:")
    public void i_enter_the_following_billing_details(List<Map<String, String>> billingDetailsRows) {
        BillingDetails billingDetails =  modelMapperUtility.mapBillingDetails(billingDetailsRows);
        checkoutPage.enterBillingDetails(billingDetails);
    }

    @When("I enter the following delivery details")
    public void i_enter_the_following_delivery_details() {

    }

    @When("I set the delivery method to {string}")
    public void i_set_the_delivery_method_to(String string) {

    }

    @When("I set the payment method to {string}")
    public void i_set_the_payment_method_to(String string) {

    }

    @When("I accept the payment method terms and conditions")
    public void i_accept_the_payment_method_terms_and_conditions() {

    }

    @When("I confirm the order")
    public void i_confirm_the_order() {

    }

    @Then("The order is placed successfully")
    public void the_order_is_placed_successfully() {

    }
}
