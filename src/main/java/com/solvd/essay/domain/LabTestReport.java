package com.solvd.essay.domain;

import java.util.Date;

public class LabTestReport {

    private Long id;
    private String essayCode;
    private Date dateOfEssay;
    private String essayDescription;

    private EquipmentForTestModel equipmentForTestModel;
    private Long equipmentForTestModelId;
    private BatchInfo batchInfo;
    private Long batchInfoId;
    private Employee employee;
    private Long employeeId;
    private EssayModule essayModule;
    private Long essayModuleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEssayCode() {
        return essayCode;
    }

    public void setEssayCode(String essayCode) {
        this.essayCode = essayCode;
    }

    public java.sql.Date getDateOfEssay() {
        return (java.sql.Date) dateOfEssay;
    }

    public void setDateOfEssay(Date dateOfEssay) {
        this.dateOfEssay = dateOfEssay;
    }

    public String getEssayDescription() {
        return essayDescription;
    }

    public void setEssayDescription(String essayDescription) {
        this.essayDescription = essayDescription;
    }

    public EquipmentForTestModel getEquipmentForTestModel() {
        return equipmentForTestModel;
    }

    public void setEquipmentForTestModel(EquipmentForTestModel equipmentForTestModel) {
        this.equipmentForTestModel = equipmentForTestModel;
    }

    public BatchInfo getBatchInfo() {
        return batchInfo;
    }

    public void setBatchInfo(BatchInfo batchInfo) {
        this.batchInfo = batchInfo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EssayModule getEssayModule() {
        return essayModule;
    }

    public void setEssayModule(EssayModule essayModule) {
        this.essayModule = essayModule;
    }

    public Long getEquipmentForTestModelId() {
        return equipmentForTestModelId;
    }

    public void setEquipmentForTestModelId(Long equipmentForTestModelId) {
        this.equipmentForTestModelId = equipmentForTestModelId;
    }

    public Long getBatchInfoId() {
        return batchInfoId;
    }

    public void setBatchInfoId(Long batchInfoId) {
        this.batchInfoId = batchInfoId;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getEssayModuleId() {
        return essayModuleId;
    }

    public void setEssayModuleId(Long essayModuleId) {
        this.essayModuleId = essayModuleId;
    }
}
