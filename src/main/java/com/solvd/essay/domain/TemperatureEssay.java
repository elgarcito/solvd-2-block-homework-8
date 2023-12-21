package com.solvd.essay.domain;

public class TemperatureEssay {

    private Long id;
    private double frontMeasurement;
    private double leftSideMeasurement;
    private boolean essayResult;
    private LabTestReport labTestReport;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getFrontMeasurement() {
        return frontMeasurement;
    }

    public void setFrontMeasurement(double frontMeasurement) {
        this.frontMeasurement = frontMeasurement;
    }

    public double getLeftSideMeasurement() {
        return leftSideMeasurement;
    }

    public void setLeftSideMeasurement(double leftSideMeasurement) {
        this.leftSideMeasurement = leftSideMeasurement;
    }

    public boolean isEssayResult() {
        return essayResult;
    }

    public void setEssayResult(boolean essayResult) {
        this.essayResult = essayResult;
    }

    public LabTestReport getLabTestReport() {
        return labTestReport;
    }

    public void setLabTestReport(LabTestReport labTestReport) {
        this.labTestReport = labTestReport;
    }
}
