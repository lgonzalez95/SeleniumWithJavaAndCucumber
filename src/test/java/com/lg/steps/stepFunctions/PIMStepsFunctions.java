package com.lg.steps.stepFunctions;

import com.lg.context.TestContext;
import com.lg.factory.PageFactory;
import com.lg.pages.EmployeeListPage;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class PIMStepsFunctions {
    EmployeeListPage employeeListPage;

    public PIMStepsFunctions(TestContext testContext) {
        this.employeeListPage = PageFactory.getEmployeeListPage(testContext.driver);
    }

    public Map<String, String> getFieldsWithDataForClassInstance(Object classInstance) {
        Map<String, String> fieldsWithData = new HashMap<>();
        Field[] fields = classInstance.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object value = field.get(classInstance);
                System.out.println(field.getName() + " = " + value);
                if (value != null) {
                    fieldsWithData.put(field.getName(), value.toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fieldsWithData;
    }
}
