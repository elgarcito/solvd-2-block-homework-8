package com.solvd.essay.domain;

public class LaboratoryTool {

    private Long id;
    private String toolName;
    private String toolDescription;


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

    @Override
    public String toString() {
        return "LaboratoryTool{" +
                "id=" + id +
                ", toolName='" + toolName + '\'' +
                ", toolDescription='" + toolDescription + '\'' +
                '}';
    }
}
