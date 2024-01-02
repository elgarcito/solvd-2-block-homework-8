package com.solvd.essay.domain;

import java.util.List;

public class GasConsumptionEssay {

    private Long id;
    private double maxConsume;
    private double standardMean;
    private double measurementError;
    private boolean essayResult;

    private LabTestReport labTestReport;
    private List<GasConsumptionEssay> gasConsumptionEssayList;



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

    public boolean isEssayResult() {
        return essayResult;
    }

    public List<GasConsumptionEssay> getGasConsumptionEssayList() {
        return gasConsumptionEssayList;
    }

    public void setGasConsumptionEssayList(List<GasConsumptionEssay> gasConsumptionEssayList) {
        this.gasConsumptionEssayList = gasConsumptionEssayList;
    }
}
