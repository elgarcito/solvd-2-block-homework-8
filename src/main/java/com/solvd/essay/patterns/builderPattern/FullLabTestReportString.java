package com.solvd.essay.patterns.builderPattern;

import java.time.LocalDate;

public class FullLabTestReportString {
    private Long id;
    private String essayCode;
    private LocalDate dateOfEssay;
    private String essayDescription;

    private String equipmentForTestModel;

    private String batchInfo;
    private String employeeName;
    private String essayModule;

    public Long getId() {
        return id;
    }

    public String getEssayCode() {
        return essayCode;
    }

    public LocalDate getDateOfEssay() {
        return dateOfEssay;
    }

    public String getEssayDescription() {
        return essayDescription;
    }

    public String getEquipmentForTestModel() {
        return equipmentForTestModel;
    }

    public String getBatchInfo() {
        return batchInfo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEssayModule() {
        return essayModule;
    }

    public static Builder builder(){
        return new Builder(new FullLabTestReportString());
    }

    @Override
    public String toString() {
        return "FullLabTestReportString{" +
                "id=" + id +
                ", essayCode='" + essayCode + '\'' +
                ", dateOfEssay=" + dateOfEssay +
                ", essayDescription='" + essayDescription + '\'' +
                ", equipmentForTestModel='" + equipmentForTestModel + '\'' +
                ", batchInfo='" + batchInfo + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", essayModule='" + essayModule + '\'' +
                '}';
    }

    public static class Builder{
        private final FullLabTestReportString fullLabTestReportString;


        public Builder(FullLabTestReportString fullLabTestReportString){
            this.fullLabTestReportString=fullLabTestReportString;
        }

        public Builder id(Long id){
            fullLabTestReportString.id=id;
            return this;
        }

        public Builder essayCode(String essayCode){
            fullLabTestReportString.essayCode=essayCode;
            return this;
        }

        public Builder dateOfEssay(LocalDate localDate){
            fullLabTestReportString.dateOfEssay=localDate;
            return this;
        }

        public Builder essayDescription(String essayDescription){
            fullLabTestReportString.essayDescription=essayDescription;
            return this;
        }

        public Builder equipmentForTestModel(String equipmentForTestModel){
            fullLabTestReportString.equipmentForTestModel=equipmentForTestModel;
            return this;
        }

        public Builder batchInfo(String batchInfo){
            fullLabTestReportString.batchInfo=batchInfo;
            return this;
        }

        public Builder employeeName(String employeeName){
            fullLabTestReportString.employeeName=employeeName;
            return this;
        }

        public Builder essayModule(String essayModule){
            fullLabTestReportString.essayModule=essayModule;
            return this;
        }

        public FullLabTestReportString build(){
            return fullLabTestReportString;
        }


    }
}
