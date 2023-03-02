package com.lg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(name = "username")
    private WebElement username;
    @FindBy(name = "password")
    private WebElement password;
    @FindBy(css = ".orangehrm-login-action button")
    private WebElement loginBtn;
    @FindBy(css = ".oxd-alert--error p")
    private WebElement loginErrorAlert;
    @FindBy(css = ".orangehrm-login-slot")
    private WebElement loginFormContainer;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void performLogin(String username, String password) {
        type(this.username, username);
        type(this.password, password);
        click(loginBtn);
    }

    public WebElement getLoginErrorAlert() {
        return waitForElementToBeVisible(loginErrorAlert);
    }

    public WebElement getLoginFormContainer() {
        return waitForElementToBeVisible(loginFormContainer);
    }
}
