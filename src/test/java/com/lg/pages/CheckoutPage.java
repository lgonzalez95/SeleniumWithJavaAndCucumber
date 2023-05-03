package com.lg.pages;

import com.lg.models.BillingDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage{
    @FindBy(css = ".radio input[value='register']")
    private WebElement registeredAccRb;
    @FindBy(css = ".radio input[value='guest']")
    private WebElement guestAccRb;
    @FindBy(id = "button-account")
    private WebElement accountBtn;

    @FindBy(id = "input-payment-firstname")
    private WebElement firstName;
    @FindBy(id = "input-payment-lastname")
    private WebElement lastName;
    @FindBy(id = "input-payment-email")
    private WebElement email;
    @FindBy(id = "input-payment-telephone")
    private WebElement telephone;
    @FindBy(id = "input-payment-company")
    private WebElement company;
    @FindBy(id = "input-payment-address-1")
    private WebElement address1;
    @FindBy(id = "input-payment-address-2")
    private WebElement address2;
    @FindBy(id = "input-payment-city")
    private WebElement city;
    @FindBy(id = "input-payment-postcode")
    private WebElement postCode;
    @FindBy(id = "input-payment-country")
    private WebElement country;
    @FindBy(id = "input-payment-zone")
    private WebElement regionOrState;


    public void continueCheckoutAsRegisteredAccount(){
        click(registeredAccRb);
        click(accountBtn);
    }

    public void continueCheckoutAsGuest(){
        click(guestAccRb);
        click(accountBtn);
    }

    public void enterBillingDetails(BillingDetails billingDetails){
        type(firstName, billingDetails.getFirstName());
        type(lastName, billingDetails.getLastName());
        type(email, billingDetails.getEmail());
        type(telephone, billingDetails.getTelephone());
        type(company, billingDetails.getCompany());
        type(address1, billingDetails.getAddress1());
        type(address2, billingDetails.getAddress2());
        type(city, billingDetails.getCity());
        type(postCode, billingDetails.getPostCode());
        selectFromDropDownUsingVisibleText(country, billingDetails.getCountry());
        selectFromDropDownUsingVisibleText(regionOrState, billingDetails.getRegion());
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
