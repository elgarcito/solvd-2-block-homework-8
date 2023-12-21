package com.solvd.essay.domain;

public class GasConsumptionEssay {

    private Long id;
    private double maxConsume;
    private double standardMean;
    private double measurement_error;
    private boolean essay_result;

    private LabTestReport labTestReport;


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

    public double getMeasurement_error() {
        return measurement_error;
    }

    public void setMeasurement_error(double measurement_error) {
        this.measurement_error = measurement_error;
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
}
