package com.lg.pages;

import com.lg.pojo.Employee;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EmployeeListPage extends BasePage {
    @FindBy(xpath = "//*[contains(text(), 'Employee Name')]/../..//input")
    private WebElement employeeName;
    @FindBy(xpath = "//*[contains(text(), 'Employee Id')]/../..//input")
    private WebElement employeeId;
    @FindBy(xpath = "//*[contains(text(), 'Employment Status')]/../..//i")
    private WebElement employeeStatus;
    @FindBy(xpath = "//*[contains(text(), 'Supervisor Name')]/../..//input")
    private WebElement supervisorName;
    @FindBy(xpath = "//*[contains(text(), 'Job Title')]/../..//i")
    private WebElement jobTitle;
    @FindBy(xpath = "//*[contains(text(), 'Sub Unit')]/../..//i")
    private WebElement subUnit;
    @FindBy(css = ".oxd-form-actions .oxd-button--secondary")
    private WebElement searchBtn;
    @FindBy(css = ".oxd-table-card")
    private List<WebElement> resultRows;
    @FindBy(css = ".oxd-table-cell")
    private List<WebElement> resultsCells;

    public EmployeeListPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getResultRows() {
        return waitForElementsToBeVisible(resultRows);
    }

    public void enterSearchCriteria(Employee employeeInfo) {
        safeType(employeeName, employeeInfo.getFirstName() + " " + employeeInfo.getLastName());
        safeType(employeeId, employeeInfo.getId());
        safeType(supervisorName, employeeInfo.getSupervisor());
    }

    public void searchEmployee() {
        click(searchBtn);
    }

    public List<WebElement> getResultsCells() {
        return resultsCells;
    }

    public WebElement findColumnBasedOnPosition(int row, int col) {
        return resultRows.get(row).findElement(By.cssSelector(".oxd-table-cell:nth-child(" + (col + 1) + ")"));
    }
}
