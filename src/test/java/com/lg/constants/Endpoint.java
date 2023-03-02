package com.lg.constants;

public enum Endpoint {
    LOGIN("/auth/login"),
    ADD_USER("/admin/saveSystemUser"),
    ADD_EMPLOYEE("/pim/addEmployee"),
    VIEW_EMPLOYEES("/pim/viewEmployeeList");

    public final String url;

    Endpoint(String url) {
        this.url = url;
    }
}
