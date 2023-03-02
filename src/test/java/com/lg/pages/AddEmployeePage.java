package com.lg.pages;

import com.lg.utils.ReplacementUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class AddEmployeePage extends BasePage {
    @FindBy(name = "firstName")
    private WebElement txtFirstName;
    @FindBy(name = "middleName")
    private WebElement txtMiddleName;
    @FindBy(name = "lastName")
    private WebElement txtLastName;
    @FindBy(xpath = "//*[contains(text(), 'Employee Id')]/../..//input")
    private WebElement txtId;
    @FindBy(className = "oxd-button--secondary")
    private WebElement btnSave;
    @FindBy(className = "oxd-button--ghost")
    private WebElement btnCancel;

    public AddEmployeePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void enterEmployeeInformation(Map<String, String> employeeInfo) {
        type(txtFirstName, ReplacementUtil.replaceStringWith(employeeInfo.get("FirstName")));
        type(txtMiddleName, ReplacementUtil.replaceStringWith(employeeInfo.get("MiddleName")));
        type(txtLastName, ReplacementUtil.replaceStringWith(employeeInfo.get("LastName")));
    }

    public void saveEmployee() {
        click(btnSave);
    }
}
