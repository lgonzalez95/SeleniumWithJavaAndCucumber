package com.lg.steps.stepDefinitions;

import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.MyAccountPage;
import com.lg.pages.LoginPage;
import com.lg.pages.components.TopNavigationBarComponent;
import com.lg.pages.sections.LogoutSection;
import com.lg.pages.sections.SectionFactory;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MyAccountSteps {
    private final MyAccountPage myAccountPage;
    private final TopNavigationBarComponent topNavigationBarComponent;
    private final LogoutSection logoutSection;

    public MyAccountSteps(TestContext testContext) {
        this.myAccountPage = PageFactory.getMyAccountPage(testContext.driver);
        this.topNavigationBarComponent = PageFactory.getTopNavigationBarComponent(testContext.driver);
        this.logoutSection = SectionFactory.getLogoutSection(testContext.driver);
    }

    @Then("My account management options are available on the page")
    public void my_account_management_options_are_available_on_the_page() {
        List<String> expectedManagementOptionsTitles = Arrays.asList("My Account", "My Orders", "My Affiliate Account", "Newsletter");
        List<String> foundManagementOptionsTitles = new ArrayList<>();
        myAccountPage.getManagementAccountOptionsLabels().forEach(element -> foundManagementOptionsTitles.add(element.getText()));
        Collections.sort(expectedManagementOptionsTitles);
        Collections.sort(foundManagementOptionsTitles);
        Assert.assertEquals(expectedManagementOptionsTitles, foundManagementOptionsTitles);
    }

    @Then("When I logout from the system")
    public void when_i_logout_from_the_system() {
        topNavigationBarComponent.logout();
    }

    @Then("I'm taken to the logout page")
    public void i_m_taken_to_the_logout_page() {
        Assert.assertEquals("Account Logout", logoutSection.getLogoutTitle().getText());
        Assert.assertEquals("You have been logged off your account. It is now safe to leave the computer.", logoutSection.getLogoutInfoLabel().getText());
        Assert.assertEquals("Your shopping cart has been saved, the items inside it will be restored whenever you log back into your account.", logoutSection.getLogoutCartInfoLabel().getText());
    }
}
