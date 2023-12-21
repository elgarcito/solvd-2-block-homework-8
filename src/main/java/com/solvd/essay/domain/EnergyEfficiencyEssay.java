package com.solvd.essay.domain;

public class EnergyEfficiencyEssay {

    private Long id;
    private double valueOfEssay;
    private String category;

    private boolean essay_result;

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

    public boolean isEssay_result() {
        return essay_result;
    }

    public void setEssay_result(boolean essay_result) {
        this.essay_result = essay_result;
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
}
