package com.solvd.essay.domain;

import java.util.Date;
import java.util.List;

public class EquipmentForTestModel {

    private Long id;
    private String modelName;
    private String modelDescription;

    private Date releaseDate;

    private List<EquipmentForTestModel> equipmentForTestModelList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDescription() {
        return modelDescription;
    }

    public void setModelDescription(String modelDescription) {
        this.modelDescription = modelDescription;
    }

    public java.sql.Date getReleaseDate() {
        return (java.sql.Date) releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<EquipmentForTestModel> getEquipmentForTestModelList() {
        return equipmentForTestModelList;
    }

    public void setEquipmentForTestModelList(List<EquipmentForTestModel> equipmentForTestModelList) {
        this.equipmentForTestModelList = equipmentForTestModelList;
    }
}
