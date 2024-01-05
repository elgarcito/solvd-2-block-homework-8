package com.solvd.essay.domain;

import java.util.List;

public class EnergyEfficiencyEssay {

    private Long id;
    private double valueOfEssay;
    private String category;

    private boolean essayResult;
    private LabTestReport labTestReport;
    private List<EnergyEfficiencyEssay> energyEfficiencyEssayList;




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


    public boolean getEssayResult(){
        return essayResult;
    }

    public void setEssayResult(boolean essayResult) {
        this.essayResult = essayResult;
    }

    public List<EnergyEfficiencyEssay> getEnergyEfficiencyEssayList() {
        return energyEfficiencyEssayList;
    }

    public void setEnergyEfficiencyEssayList(List<EnergyEfficiencyEssay> energyEfficiencyEssayList) {
        this.energyEfficiencyEssayList = energyEfficiencyEssayList;
    }

    @Override
    public String toString() {
        String labTestReportValue=null;

        if (labTestReport==null){
            labTestReportValue="null";
        }else {
            labTestReportValue= labTestReport.toString();
        }

        return "EnergyEfficiencyEssay{" +
                "id=" + id +
                ", valueOfEssay=" + valueOfEssay +
                ", category='" + category + '\'' +
                ", essayResult=" + essayResult +
                ", labTestReport=" + labTestReportValue +
                '}';
    }
}
