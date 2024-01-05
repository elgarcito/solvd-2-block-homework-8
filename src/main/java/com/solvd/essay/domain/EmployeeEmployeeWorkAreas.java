package com.solvd.essay.domain;

public class EmployeeEmployeeWorkAreas {
    private Long id;
    private Employee employee;

    private EmployeeWorkArea employeeWorkArea;

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

    @Override
    public String toString() {
        return "EmployeeEmployeeWorkAreas{" +
                "id=" + id +
                ", employee=" + employee.toString() +
                ", employeeWorkArea=" + employeeWorkArea.toString() +
                '}';
    }
}
