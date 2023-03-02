package com.lg.pages.sections;

import com.lg.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutSection extends BasePage {
    @FindBy(css = "#content h1")
    WebElement logoutTitle;
    @FindBy(xpath = "//*[@id='content']/p[1]")
    WebElement logoutInfoLabel;
    @FindBy(xpath = "//*[@id='content']/p[2]")
    WebElement logoutCartInfoLabel;
    public LogoutSection(WebDriver driver) {
        super(driver);
    }

    public WebElement getLogoutTitle() {
        return logoutTitle;
    }

    public WebElement getLogoutInfoLabel() {
        return logoutInfoLabel;
    }

    public WebElement getLogoutCartInfoLabel() {
        return logoutCartInfoLabel;
    }
}
