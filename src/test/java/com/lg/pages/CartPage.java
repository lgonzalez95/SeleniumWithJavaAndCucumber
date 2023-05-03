package com.lg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CartPage extends BasePage {
    @FindBy(css = "form thead td")
    private List<WebElement> cartElementsTableHeaders;
    @FindBy(css = "form tbody tr ")
    private List<WebElement> cartElementsRows;
    @FindBy(xpath = "//*[text()='Total:']/parent::td//following-sibling::td")
    private WebElement totalAmount;
    @FindBy(xpath = "//a[text()='Checkout']")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getTotalAmount() {
        return waitForElementToBeVisible(totalAmount).getText();
    }

    public void proceedToCheckoutPage() {
        waitForElementToBeVisible(checkoutBtn).click();
    }

    public List<Map<String, String>> getCartItemDetails() {
        List<Map<String, String>> productsInCart = new ArrayList<Map<String, String>>();

        for (WebElement row : cartElementsRows) {
            Map<String, String> product = new HashMap<String, String>();
            List<WebElement> cells = row.findElements(By.xpath(".//td"));
            for (int i = 1; i < cells.size(); i++) {
                if (cartElementsTableHeaders.get(i).getText().equalsIgnoreCase("Quantity")) {
                    product.put(cartElementsTableHeaders.get(i).getText(), cells.get(i).findElement(By.cssSelector("input")).getAttribute("value"));
                } else {
                    product.put(cartElementsTableHeaders.get(i).getText(), cells.get(i).getText());
                }
            }
            productsInCart.add(product);
        }
        return productsInCart;
    }
}
