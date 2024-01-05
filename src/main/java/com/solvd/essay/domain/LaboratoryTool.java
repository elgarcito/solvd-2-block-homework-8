package com.solvd.essay.domain;

import java.util.List;

public class LaboratoryTool {

    private Long id;
    private String toolName;
    private String toolDescription;
    private List<LaboratoryTool> laboratoryToolList;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToolName() {
        return toolName;
    }

    public void setToolName(String toolName) {
        this.toolName = toolName;
    }

    public String getToolDescription() {
        return toolDescription;
    }

    public void setToolDescription(String toolDescription) {
        this.toolDescription = toolDescription;
    }

    public List<LaboratoryTool> getLaboratoryToolList() {
        return laboratoryToolList;
    }

    public void setLaboratoryToolList(List<LaboratoryTool> laboratoryToolList) {
        this.laboratoryToolList = laboratoryToolList;
    }

    @Override
    public String toString() {
        return "LaboratoryTool{" +
                "id=" + id +
                ", toolName='" + toolName + '\'' +
                ", toolDescription='" + toolDescription + '\'' +
                '}';
    }
}
