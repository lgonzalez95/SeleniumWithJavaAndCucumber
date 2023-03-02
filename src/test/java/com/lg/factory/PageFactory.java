package com.lg.factory;

import com.lg.pages.*;
import com.lg.pages.components.TopNavigationBarComponent;
import com.lg.pages.sections.LogoutSection;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static TopNavigationBarComponent topNavigationBarComponent;
    private static MyAccountPage myAccountPage;
    private static LogoutSection logoutSection;
    private static LoginPage loginPage;
    private static BasePage basePage;

    public static TopNavigationBarComponent getTopNavigationBarComponent(WebDriver driver) {
        return topNavigationBarComponent == null ? new TopNavigationBarComponent(driver) : topNavigationBarComponent;
    }

    public static MyAccountPage getMyAccountPage(WebDriver driver) {
        return myAccountPage == null ? new MyAccountPage(driver) : myAccountPage;
    }

    public static LogoutSection getLogoutSection(WebDriver driver) {
        return logoutSection == null ? new LogoutSection(driver) : logoutSection;
    }

    public static BasePage getBasePage(WebDriver driver) {
        return basePage == null ? new BasePage(driver) : basePage;
    }

    public static LoginPage getLoginPage(WebDriver driver) {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }
}
