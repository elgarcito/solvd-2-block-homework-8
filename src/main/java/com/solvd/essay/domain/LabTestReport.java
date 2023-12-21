package com.solvd.essay.domain;

import java.util.Date;

public class LabTestReport {

    private Long id;
    private String essayCode;
    private Date dateOfEssay;
    private String essayDescription;

    private EquipmentForTestModel equipmentForTestModel;
    private BatchInfo batchInfo;
    private Employee employee;
    private EssayModule essayModule;


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

    public Date getDateOfEssay() {
        return dateOfEssay;
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
}
