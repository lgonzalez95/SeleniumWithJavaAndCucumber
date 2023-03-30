package com.lg.pages.sections;

import com.lg.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderSection extends BasePage {
    @Getter
    @FindBy(name = "search")
    WebElement searchBar;
    @Getter
    @FindBy(css = ".input-group-btn button")
    WebElement searchBtn;
    @FindBy(linkText = "Shopping Cart")
    WebElement cartBtn;

    public HeaderSection(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName){
        waitForElementToBeVisible(searchBar).clear();
        type(searchBar, productName);
        click(searchBtn);
    }

    public void goToCart(){
        click(cartBtn);
    }
}
