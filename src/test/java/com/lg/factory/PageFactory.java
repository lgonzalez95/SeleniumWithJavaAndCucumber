package com.lg.factory;

import com.lg.pages.*;
import com.lg.pages.components.TopNavigationBarComponent;
import com.lg.pages.sections.LogoutSection;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static TopNavigationBarComponent topNavigationBarComponent;
    private static MyAccountPage myAccountPage;
    private static LoginPage loginPage;
    private static BasePage basePage;
    private static ProductPage productPage;
    private static ResultsPage resultsPage;

    public static TopNavigationBarComponent getTopNavigationBarComponent(WebDriver driver) {
        return topNavigationBarComponent == null ? new TopNavigationBarComponent(driver) : topNavigationBarComponent;
    }

    public static MyAccountPage getMyAccountPage(WebDriver driver) {
        return myAccountPage == null ? new MyAccountPage(driver) : myAccountPage;
    }

    public static BasePage getBasePage(WebDriver driver) {
        return basePage == null ? new BasePage(driver) : basePage;
    }

    public static LoginPage getLoginPage(WebDriver driver) {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static ProductPage getProductPage(WebDriver driver) {
        return productPage == null ? new ProductPage(driver) : productPage;
    }

    public static ResultsPage getResultsPage(WebDriver driver) {
        return resultsPage == null ? new ResultsPage(driver) : resultsPage;
    }
}
