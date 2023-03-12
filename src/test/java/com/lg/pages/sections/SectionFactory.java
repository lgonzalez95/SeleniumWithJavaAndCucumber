package com.lg.pages.sections;

import org.openqa.selenium.WebDriver;

public class SectionFactory {
    private static LogoutSection logoutSection;
    private static HeaderSection headerSection;

    public static LogoutSection getLogoutSection(WebDriver driver) {
        return logoutSection == null ? new LogoutSection(driver) : logoutSection;
    }

    public static HeaderSection getHeaderSection(WebDriver driver) {
        return headerSection == null ? new HeaderSection(driver) : headerSection;
    }
}
