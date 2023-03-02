package com.lg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BasePage {

    @FindBy(css = ".oxd-userdropdown")
    private WebElement userProfileMenu;
    @FindBy(linkText = "Logout")
    private WebElement logoutLink;
    @FindBy(css = "#oxd-toaster_1 .oxd-text--toast-message")
    private WebElement alertPopup;

    public DashboardPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logout() {
        click(userProfileMenu);
        click(logoutLink);
    }

    public WebElement getAlertPopup() {
        return waitForElementToBeVisible(alertPopup);
    }
}
