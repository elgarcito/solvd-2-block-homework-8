package com.solvd.essay.domain;

import java.util.List;

public class EmployeeEmployeeWorkAreas {
    private Long id;
    private Employee employee;
    private Long employeeId;
    private EmployeeWorkArea employeeWorkArea;
    private Long employeeworkAreaId;


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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEmployeeworkAreaId() {
        return employeeworkAreaId;
    }

    public void setEmployeeworkAreaId(Long employeeworkAreaId) {
        this.employeeworkAreaId = employeeworkAreaId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
