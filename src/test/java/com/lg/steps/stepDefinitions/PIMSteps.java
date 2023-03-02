package com.lg.steps.stepDefinitions;

import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.AddEmployeePage;
import com.lg.pages.DashboardPage;
import com.lg.pages.EmployeeListPage;
import com.lg.pojo.Employee;
import com.lg.steps.stepFunctions.PIMStepsFunctions;
import com.lg.utils.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;

import java.lang.reflect.Field;
import java.util.*;

public class PIMSteps {
    AddEmployeePage addEmployeePage;
    DashboardPage dashboardPage;
    EmployeeListPage employeeListPage;
    Employee employeeInfo = null;
    PIMStepsFunctions pimStepsFunctions;
    List<WebElement> initialRows = null;

    public PIMSteps(TestContext testContext) {
        this.addEmployeePage = PageFactory.getAddEmployeePage(testContext.driver);
        this.dashboardPage = PageFactory.getDashboardPage(testContext.driver);
        this.employeeListPage = PageFactory.getEmployeeListPage(testContext.driver);
        pimStepsFunctions = new PIMStepsFunctions(testContext);
    }

    @Given("I enter the following user information")
    public void i_enter_the_following_user_information(List<Map<String, String>> rows) {
        Map<String, String> employeeInfo = rows.get(0);
        addEmployeePage.enterEmployeeInformation(employeeInfo);
    }

    @When("I click on the save user button")
    public void i_click_on_the_save_user_button() {
        addEmployeePage.saveEmployee();
    }

    @Then("The user is saved successfully")
    public void the_user_is_saved_successfully() {
        String alertMessage = dashboardPage.getAlertPopup().getText();
        Assert.assertEquals("Employment saved", alertMessage, "Successfully Saved");
    }

    @Given("I enter the following employee search criteria")
    public void i_enter_the_following_employee_search_criteria(DataTable employeeSearch) {
        employeeInfo = ObjectMapper.mapEmployee(employeeSearch).get(0);
        initialRows = employeeListPage.getResultRows();
        employeeListPage.enterSearchCriteria(employeeInfo);
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
        employeeListPage.searchEmployee();
    }

    @Then("Results are retrieved matching the following information")
    public void results_are_retrieved(DataTable employeeSearchCriteria) {
        employeeInfo = ObjectMapper.mapEmployee(employeeSearchCriteria).get(0);
        Map<String, String> fieldsToCheck = pimStepsFunctions.getFieldsWithDataForClassInstance(employeeInfo);
        List<WebElement> employeesRows = employeeListPage.getResultRows();
        List<WebElement> employeesCellsFound = employeeListPage.getResultsCells();

        Assert.assertTrue("There were rows returned", employeesRows.size() > 0);
        for (int i = 0; i < employeesRows.size(); i++) {
            StringBuilder resultsAsString = new StringBuilder();
            for (int j = 0; j < employeesCellsFound.size(); j++) {
                String cellValue = employeeListPage.findColumnBasedOnPosition(i, j).getText();
                if (!cellValue.isEmpty() && !cellValue.isBlank()) {
                    resultsAsString.append(cellValue).append(" ");
                }
            }
            fieldsToCheck.forEach((key, value) -> Assert.assertTrue("The search field value is present in the current row", resultsAsString.toString().contains(value)));
        }
    }
}
