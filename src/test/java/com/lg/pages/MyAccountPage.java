package com.lg.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyAccountPage extends BasePage {

    @FindBy(css = "#content h2")
    private List<WebElement> managementAccountOptionsLabels;


    public MyAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getManagementAccountOptionsLabels() {
        return managementAccountOptionsLabels;
    }
}
