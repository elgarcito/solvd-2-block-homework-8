package com.solvd.essay.domain;

public class EnergyEfficiencyEssay {

    private Long id;
    private double valueOfEssay;
    private String category;

    private boolean essayResult;

    private Long labTestReportId;
    private LabTestReport labTestReport;



    public double getValueOfEssay() {
        return valueOfEssay;
    }

    public void setValueOfEssay(double valueOfEssay) {
        this.valueOfEssay = valueOfEssay;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean essayResult() {
        return essayResult;
    }


    public LabTestReport getLabTestReport() {
        return labTestReport;
    }

    public void setLabTestReport(LabTestReport labTestReport) {
        this.labTestReport = labTestReport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getLabTestReportId() {
        return labTestReportId;
    }

    public void setLabTestReportId(Long labTestReportId) {
        this.labTestReportId = labTestReportId;
    }

    public boolean getEssayResult(){
        return essayResult;
    }

    public void setEssayResult(boolean essayResult) {
        this.essayResult = essayResult;
    }

    @Override
    public String toString() {
        return "EnergyEfficiencyEssay{" +
                "id=" + id +
                ", valueOfEssay=" + valueOfEssay +
                ", category='" + category + '\'' +
                ", essayResult=" + essayResult +
                ", labTestReport=" + labTestReport.toString() +
                '}';
    }
}
