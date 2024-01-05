package com.solvd.essay.domain;

public class EmployeeLaboratoryTools {
    private Long id;

    private Employee employee;
    private Long employeeId;
    private LaboratoryTool laboratoryTool;
    private Long laboratoryToolId;
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

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getLaboratoryToolId() {
        return laboratoryToolId;
    }

    public void setLaboratoryToolId(Long laboratoryToolId) {
        this.laboratoryToolId = laboratoryToolId;
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
