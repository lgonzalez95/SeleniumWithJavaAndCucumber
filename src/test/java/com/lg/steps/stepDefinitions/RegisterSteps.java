package com.lg.steps.stepDefinitions;

import com.lg.constants.Domains;
import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.models.ElementValidationError;
import com.lg.models.PersonalDetails;
import com.lg.pages.LoginPage;
import com.lg.pages.RegisterPage;
import com.lg.utils.ModelMapperUtility;
import com.lg.utils.ReplacementUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class RegisterSteps {
    private final RegisterPage registerPage;
    private ModelMapperUtility modelMapperUtility;

    public RegisterSteps(TestContext testContext, ModelMapperUtility modelMapperUtility) {
        this.registerPage = PageFactory.getRegisterPage(testContext.driver);
        this.modelMapperUtility = modelMapperUtility;
    }

    @When("I click the continue button")
    public void i_click_the_continue_button() {
        registerPage.registerAccount();
    }

    @Then("The following validation messages are displayed for the register account fields")
    public void the_following_validation_messages_are_displayed_for_the_register_account_fields(List<Map<String, String>> validationsForFields) {
        List<ElementValidationError> expectedValidations = modelMapperUtility.mapExpectedValidationsForFields(validationsForFields);
        List<String> validationMessages = registerPage.getValidationMessages();
        expectedValidations.forEach(expectedValidation -> Assert.assertTrue(validationMessages.contains(expectedValidation.getValidationMessage())));
    }

    @And("I enter the following personal details:")
    public void i_enter_the_following_personal_details(List<Map<String, String>> personalDetailsRows) {
        PersonalDetails personalDetails = modelMapperUtility.mapPersonalDetails(personalDetailsRows);
        personalDetails.setPassword(ReplacementUtil.replaceStringWith(personalDetails.getPassword()));
        String user = ReplacementUtil.replaceStringWith(personalDetails.getEmail());
        String newEmail = user + Domains.TESTING_COM.domain;
        personalDetails.setEmail(newEmail);
        registerPage.enterNewAccountDetails(personalDetails);
    }

    @Then("The new user is registered successfully")
    public void the_new_user_is_registered_successfully() {
        Assert.assertTrue(
                "The account was registered successfully",
                registerPage.isTextContainedInPageSource("Your Account Has Been Created!")
        );
    }
}
