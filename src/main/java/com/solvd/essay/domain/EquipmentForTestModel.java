package com.solvd.essay.domain;


import jakarta.xml.bind.annotation.*;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@XmlRootElement(name="equipmentForTestModel")
@XmlAccessorType(XmlAccessType.FIELD)
public class EquipmentForTestModel {
    @XmlAttribute(name="id")
    private Long id;
    private String modelName;
    private String modelDescription;
    @XmlJavaTypeAdapter(value= LocalDateTimeAdapter.class)
    private LocalDate releaseDate;
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


    public LocalDate getReleaseDate() {
        return  releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<EquipmentForTestModel> getEquipmentForTestModelList() {
        return equipmentForTestModelList;
    }

    public void setEquipmentForTestModelList(List<EquipmentForTestModel> equipmentForTestModelList) {
        this.equipmentForTestModelList = equipmentForTestModelList;
    }

    @Override
    public String toString() {
        return "EquipmentForTestModel{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", modelDescription='" + modelDescription + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
