package com.solvd.essay.domain;

public class EmployeeWorkArea {

    private Long id;
    private String areaName;
    private String areaCode;

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "EmployeeWorkArea{" +
                "id=" + id +
                ", areaName='" + areaName + '\'' +
                ", areaCode='" + areaCode + '\'' +
                '}';
    }
}
