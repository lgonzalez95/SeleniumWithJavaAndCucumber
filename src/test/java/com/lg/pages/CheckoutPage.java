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
    @FindBy(id = "button-guest")
    private WebElement billingDetailsContinueBtn;
    @FindBy(name = "shipping_address")
    private WebElement deliveryAndBillingAddressAreTheSameChk;
    @FindBy(id = "button-shipping-method")
    private WebElement deliveryMethodContinueBtn;
    @FindBy(id = "shipping_method")
    private WebElement shippingMethodDeliveryRb;
    @FindBy(id = "button-guest-shipping")
    private WebElement deliveryDetailsContinueBtn;


    @FindBy(id = "input-payment-firstname")
    private WebElement paymentFirstName;
    @FindBy(id = "input-payment-lastname")
    private WebElement paymentLastName;
    @FindBy(id = "input-payment-email")
    private WebElement paymentEmail;
    @FindBy(id = "input-payment-telephone")
    private WebElement paymentTelephone;
    @FindBy(id = "input-payment-company")
    private WebElement paymentCompany;
    @FindBy(id = "input-payment-address-1")
    private WebElement paymentAddress1;
    @FindBy(id = "input-payment-address-2")
    private WebElement paymentAddress2;
    @FindBy(id = "input-payment-city")
    private WebElement paymentCity;
    @FindBy(id = "input-payment-postcode")
    private WebElement paymentPostCode;
    @FindBy(id = "input-payment-country")
    private WebElement paymentCountry;
    @FindBy(id = "input-payment-zone")
    private WebElement paymentRegionOrState;

    @FindBy(id = "input-shipping-firstname")
    private WebElement shippingFirstName;
    @FindBy(id = "input-shipping-lastname")
    private WebElement shippingLastName;
    @FindBy(id = "input-shipping-company")
    private WebElement shippingCompany;
    @FindBy(id = "input-shipping-address-1")
    private WebElement shippingAddress1;
    @FindBy(id = "input-shipping-address-2")
    private WebElement shippingAddress2;
    @FindBy(id = "input-shipping-city")
    private WebElement shippingCity;
    @FindBy(id = "input-shipping-postcode")
    private WebElement shippingPostCode;
    @FindBy(id = "input-shipping-country")
    private WebElement shippingCountry;
    @FindBy(id = "input-shipping-zone")
    private WebElement shippingRegionOrState;


    public void continueCheckoutAsRegisteredAccount(){
        click(registeredAccRb);
        click(accountBtn);
    }

    public void continueCheckoutAsGuest(){
        click(guestAccRb);
        click(accountBtn);
    }

    public void continueToDeliveryDetails(){
        click(billingDetailsContinueBtn);
    }

    public void useDifferentDeliveryAddress(){
        click(deliveryAndBillingAddressAreTheSameChk);
    }

    public void setShippingDeliveryMethod(){
        click(shippingMethodDeliveryRb);
    }

    public void continueToPayment(){
        click(deliveryMethodContinueBtn);
    }

    public void continueToDeliveryMethod(){
        click(deliveryDetailsContinueBtn);
    }

    public void enterBillingDetails(BillingDetails billingDetails){
        type(paymentFirstName, billingDetails.getFirstName());
        type(paymentLastName, billingDetails.getLastName());
        type(paymentEmail, billingDetails.getEmail());
        type(paymentTelephone, billingDetails.getTelephone());
        type(paymentCompany, billingDetails.getCompany());
        type(paymentAddress1, billingDetails.getAddress1());
        type(paymentAddress2, billingDetails.getAddress2());
        type(paymentCity, billingDetails.getCity());
        type(paymentPostCode, billingDetails.getPostCode());
        selectFromDropDownUsingVisibleText(paymentCountry, billingDetails.getCountry());
        selectFromDropDownUsingVisibleText(paymentRegionOrState, billingDetails.getRegion());
    }

    public void enterDeliveryDetails(BillingDetails billingDetails){
        type(shippingFirstName, billingDetails.getFirstName());
        type(shippingLastName, billingDetails.getLastName());
        type(shippingCompany, billingDetails.getCompany());
        type(shippingAddress1, billingDetails.getAddress1());
        type(shippingAddress2, billingDetails.getAddress2());
        type(shippingCity, billingDetails.getCity());
        type(shippingPostCode, billingDetails.getPostCode());
        selectFromDropDownUsingVisibleText(shippingCountry, billingDetails.getCountry());
        selectFromDropDownUsingVisibleText(shippingRegionOrState, billingDetails.getRegion());
    }

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
