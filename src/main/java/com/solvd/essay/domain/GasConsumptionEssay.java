package com.solvd.essay.domain;

public class GasConsumptionEssay {

    private Long id;
    private double maxConsume;
    private double standardMean;
    private double measurementError;
    private boolean essayResult;

    private LabTestReport labTestReport;

    private Long labTestReportId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getMaxConsume() {
        return maxConsume;
    }

    public void setMaxConsume(double maxConsume) {
        this.maxConsume = maxConsume;
    }

    public double getStandardMean() {
        return standardMean;
    }

    public void setStandardMean(double standardMean) {
        this.standardMean = standardMean;
    }

    public double getMeasurementError() {
        return measurementError;
    }

    public void setMeasurementError(double measurementError) {
        this.measurementError = measurementError;
    }

    public LabTestReport getLabTestReport() {
        return labTestReport;
    }

    public void setLabTestReport(LabTestReport labTestReport) {
        this.labTestReport = labTestReport;
    }
    public boolean getEssayResult(){
        return essayResult;
    }

    public void setEssayResult(boolean essayResult) {
        this.essayResult = essayResult;
    }

    public Long getLabTestReportId() {
        return labTestReportId;
    }

    public void setLabTestReportId(Long labTestReportId) {
        this.labTestReportId = labTestReportId;
    }

}
