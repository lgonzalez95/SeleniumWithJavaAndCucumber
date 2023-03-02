package com.lg.utils;

import com.lg.pojo.Employee;
import io.cucumber.datatable.DataTable;

import java.util.List;

public class ObjectMapper {
    public static List<Employee> mapEmployee(DataTable table) {
        return table.asMaps().stream()
                .map(employee -> new Employee(
                        employee.get("FirstName"),
                        employee.get("LastName"),
                        employee.get("Id"),
                        employee.get("Supervisor"),
                        employee.get("JobTitle"),
                        employee.get("SubUnit"))
                ).toList();
    }
}
