package com.solvd.essay.domain;

import java.util.List;

public class EmployeeEmployeeWorkAreas {
    private Long id;
    private Employee employee;
    private EmployeeWorkArea employeeWorkArea;

    private List<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasList;


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeWorkArea getEmployeeWorkArea() {
        return employeeWorkArea;
    }

    public void setEmployeeWorkArea(EmployeeWorkArea employeeWorkArea) {
        this.employeeWorkArea = employeeWorkArea;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<EmployeeEmployeeWorkAreas> getEmployeeEmployeeWorkAreasList() {
        return employeeEmployeeWorkAreasList;
    }

    public void setEmployeeEmployeeWorkAreasList(List<EmployeeEmployeeWorkAreas> employeeEmployeeWorkAreasList) {
        this.employeeEmployeeWorkAreasList = employeeEmployeeWorkAreasList;
    }
}
