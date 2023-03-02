package com.lg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(id = "input-email")
    private WebElement email;
    @FindBy(id = "input-password")
    private WebElement password;
    @FindBy(css = "input[value='Login']")
    private WebElement loginBtn;
    @FindBy(className = "alert-danger")
    private WebElement loginErrorLabel;




    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void performLogin(String username, String password) {
        type(this.email, username);
        type(this.password, password);
        click(loginBtn);
    }

    public WebElement getLoginErrorAlert() {
        return waitForElementToBeVisible(loginErrorLabel);
    }
}
