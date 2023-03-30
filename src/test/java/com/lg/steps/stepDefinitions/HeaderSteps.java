package com.lg.steps.stepDefinitions;

import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.ProductPage;
import com.lg.pages.ResultsPage;
import com.lg.pages.sections.HeaderSection;
import com.lg.pages.sections.SectionFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class HeaderSteps {
    ProductPage productPage;
    HeaderSection headerSection;
    ResultsPage resultsPage;

    public HeaderSteps(TestContext testContext){
        this.productPage = PageFactory.getProductPage(testContext.driver);
        this.headerSection = SectionFactory.getHeaderSection(testContext.driver);
        this.resultsPage = PageFactory.getResultsPage(testContext.driver);
    }

    @Given("I add the following products to the cart:")
    public void i_add_the_following_products_to_the_cart(DataTable dataTable) {
        List<Map<String, String>> products = dataTable.asMaps();

        products.forEach(product -> {
            this.headerSection.searchProduct(product.get("Product Name"));
            this.resultsPage.openMatchingProduct(product.get("Product Name"));
            this.productPage.addProductToCart();
        });
    }

    @When("I click the cart button from the header bar")
    public void i_click_the_checkout_button_from_the_header_bar() {
        headerSection.goToCart();
    }

}
