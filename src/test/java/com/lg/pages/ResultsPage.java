package com.lg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultsPage extends BasePage {
    @FindBy(className = "product-layout")
    List<WebElement> searchResults;
    private final String productNameSelector = "h4 a";

    public ResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openMatchingProduct(String productNameExpected) {
        waitForElementsToBeVisible(searchResults);
        searchResults.forEach(productFound -> {
            WebElement actualProductName = waitForElementToBeVisible(productFound.findElement(By.cssSelector(productNameSelector)));
            if (actualProductName.getText().equalsIgnoreCase(productNameExpected)) {
                click(actualProductName);
            }
        });
    }
}
