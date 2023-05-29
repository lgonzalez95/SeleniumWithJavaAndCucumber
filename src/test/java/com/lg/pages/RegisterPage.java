package com.lg.pages;

import com.lg.models.PersonalDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class RegisterPage extends BasePage {
    @FindBy(name = "agree")
    private WebElement agreeAndAcceptTermsChk;
    @FindBy(css = ".buttons input[value='Continue']")
    private WebElement continueBtn;
    @FindBy(css = "div .text-danger")
    private List<WebElement> elementsWithValidationErrors;

    @FindBy(id = "input-firstname")
    private WebElement firstName;
    @FindBy(id = "input-lastname")
    private WebElement lastName;
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-telephone")
    private WebElement telephone;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(id = "input-confirm")
    private WebElement confirmPassword;

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registerAccount() {
        click(agreeAndAcceptTermsChk);
        click(continueBtn);
    }

    public void enterNewAccountDetails(PersonalDetails personalDetails){
        type(firstName, personalDetails.getFirstName());
        type(lastName, personalDetails.getLastName());
        type(email, personalDetails.getEmail());
        type(telephone, personalDetails.getTelephone());
        type(password, personalDetails.getPassword());
        type(confirmPassword, personalDetails.getPassword());
    }

    public List<String> getValidationMessages() {
        return waitForElementsToBeVisible(elementsWithValidationErrors).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
