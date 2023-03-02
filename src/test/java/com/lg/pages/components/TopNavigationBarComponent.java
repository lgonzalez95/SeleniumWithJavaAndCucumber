package com.lg.pages.components;

import com.lg.pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopNavigationBarComponent extends BasePage {
    @FindBy(css = "a[title='My Account']")
    private WebElement myAccountMenu;
    @FindBy(xpath = "//*[@id='top-links']//a[contains(text(), 'Login')]")
    private WebElement loginLink;
    @FindBy(xpath = "//*[@id='top-links']//a[contains(text(), 'Register')]")
    private WebElement registerLink;
    @FindBy(xpath = "//*[@id='top-links']//a[contains(text(), 'Logout')]")
    private WebElement logout;

    public TopNavigationBarComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void logout(){
        click(myAccountMenu);
        click(logout);
    }
}
