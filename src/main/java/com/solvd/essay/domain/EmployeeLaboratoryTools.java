package com.solvd.essay.domain;

import java.util.List;

public class EmployeeLaboratoryTools {
    private Long id;

    private Employee employee;

    private LaboratoryTool laboratoryTool;
    private List<EmployeeLaboratoryTools> employeeLaboratoryToolsList;
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public LaboratoryTool getLaboratoryTool() {
        return laboratoryTool;
    }

    public void setLaboratoryTool(LaboratoryTool laboratoryTool) {
        this.laboratoryTool = laboratoryTool;
    }

    public List<EmployeeLaboratoryTools> getEmployeeLaboratoryToolsList() {
        return employeeLaboratoryToolsList;
    }

    public void setEmployeeLaboratoryToolsList(List<EmployeeLaboratoryTools> employeeLaboratoryToolsList) {
        this.employeeLaboratoryToolsList = employeeLaboratoryToolsList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeLaboratoryTools{" +
                "id=" + id +
                ", employee=" + employee.toString() +
                ", laboratoryTool=" + laboratoryTool.toString() +
                '}';
    }
}
