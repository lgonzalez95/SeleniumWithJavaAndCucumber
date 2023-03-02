package com.lg.factory;

import com.lg.pages.AddEmployeePage;
import com.lg.pages.DashboardPage;
import com.lg.pages.EmployeeListPage;
import com.lg.pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class PageFactory {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static AddEmployeePage addEmployeePage;
    private static EmployeeListPage employeeListPage;

    public static LoginPage getLoginPage(WebDriver driver) {
        return loginPage == null ? new LoginPage(driver) : loginPage;
    }

    public static DashboardPage getDashboardPage(WebDriver driver) {
        return dashboardPage == null ? new DashboardPage(driver) : dashboardPage;
    }

    public static AddEmployeePage getAddEmployeePage(WebDriver driver) {
        return addEmployeePage == null ? new AddEmployeePage(driver) : addEmployeePage;
    }

    public static EmployeeListPage getEmployeeListPage(WebDriver driver) {
        return employeeListPage == null ? new EmployeeListPage(driver) : employeeListPage;
    }
}
