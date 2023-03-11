package com.lg.pages.sections;

import com.lg.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutSection extends BasePage {
    @FindBy(css = "#content h1")
    @Getter
    WebElement logoutTitle;
    @FindBy(xpath = "//*[@id='content']/p[1]")
    @Getter
    WebElement logoutInfoLabel;
    @FindBy(xpath = "//*[@id='content']/p[2]")
    @Getter
    WebElement logoutCartInfoLabel;
    public LogoutSection(WebDriver driver) {
        super(driver);
    }
}
