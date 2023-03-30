package com.lg.steps.stepDefinitions;

import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class CartSteps {
    private CartPage cartPage;

    public CartSteps(TestContext testContext) {
        this.cartPage = PageFactory.getCartPage(testContext.driver);
    }

    @Then("The cart contains the following products:")
    public void the_cart_contains_the_following_products(List<Map<String, String>> expectedProducts) {
        List<Map<String, String>> products = cartPage.getCartItemDetails();
        for (int i = 0; i < expectedProducts.size(); i++) {
            Assert.assertTrue(products.get(i).get("Product Name").contains(expectedProducts.get(i).get("Product Name")));
            Assert.assertEquals(expectedProducts.get(i).get("Quantity"), products.get(i).get("Quantity"));
            Assert.assertEquals(expectedProducts.get(i).get("Unit Price"), products.get(i).get("Unit Price"));
            Assert.assertEquals(expectedProducts.get(i).get("Total"), products.get(i).get("Total"));
        }
    }

    @And("The total amount to pay is {string}")
    public void the_total_amount_to_pay_is(String expectedTotal) {
        Assert.assertEquals(expectedTotal, cartPage.getTotalAmount().getText());
    }
}
