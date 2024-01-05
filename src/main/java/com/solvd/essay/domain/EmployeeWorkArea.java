package com.solvd.essay.domain;

import java.util.List;

public class EmployeeWorkArea {

    private Long id;
    private String areaName;
    private String areaCode;
    private List<EmployeeWorkArea> employeeWorkAreaList;

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

    public List<EmployeeWorkArea> getEmployeeWorkAreaList() {
        return employeeWorkAreaList;
    }

    public void setEmployeeWorkAreaList(List<EmployeeWorkArea> employeeWorkAreaList) {
        this.employeeWorkAreaList = employeeWorkAreaList;
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
