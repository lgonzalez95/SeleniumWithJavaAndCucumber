package com.lg.pojo;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String id;
    private final String supervisor;
    private final String jobTitle;
    private final String subUnit;

    public Employee(String firstName, String lastName, String id, String supervisor, String jobTitle, String subUnit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.supervisor = supervisor;
        this.jobTitle = jobTitle;
        this.subUnit = subUnit;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getId() {
        return id;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getSubUnit() {
        return subUnit;
    }
}