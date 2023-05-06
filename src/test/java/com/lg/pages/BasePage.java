package com.lg.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.lg.utils.ConfigLoader;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void load(String endpoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endpoint);
    }

    public void click(WebElement element) {
        waitForElementToClickable(element).click();
    }

    public void type(WebElement element, String text) {
        waitForElementToBeVisible(element).sendKeys(text);
    }

    public void safeType(WebElement element, String text) {
        if (text != null && !text.isEmpty() && !text.isBlank()) {
            waitForElementToBeVisible(element).sendKeys(text);
        }
    }

    public WebElement waitForElementToBeVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public List<WebElement> waitForElementsToBeVisible(List<WebElement> elements) {
        return wait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public WebElement waitForElementToClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getCurrentPageUrl(){
        return driver.getCurrentUrl();
    }

    public void selectFromDropDownUsingVisibleText(WebElement selectWebElement, String visibleText) {
        Select select = new Select(selectWebElement);
        select.selectByVisibleText(visibleText);
        WebElement selectedOption = select.getFirstSelectedOption();
        wait.until(ExpectedConditions.visibilityOf(selectedOption));
    }

    public boolean isTextContainedInPageSource(String expectedText){
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), expectedText));
    }
}
