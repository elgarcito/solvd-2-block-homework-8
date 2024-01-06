package com.solvd.essay.domain;

import com.solvd.essay.LocalDateTimeAdapter;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import java.time.LocalDate;
import java.util.List;
@XmlRootElement(name="labTestReport")
@XmlAccessorType(XmlAccessType.FIELD)
public class LabTestReport {
    @XmlAttribute(name="id")
    private Long id;
    private String essayCode;
    @XmlJavaTypeAdapter(value= LocalDateTimeAdapter.class)
    private LocalDate dateOfEssay;
    private String essayDescription;

    private EquipmentForTestModel equipmentForTestModel;

    private BatchInfo batchInfo;
    private Employee employee;
    private EssayModule essayModule;
    private List<LabTestReport> labTestReportList;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEssayCode() {
        return essayCode;
    }

    public void setEssayCode(String essayCode) {
        this.essayCode = essayCode;
    }

    public LocalDate getDateOfEssay() {
        return dateOfEssay;
    }

    public void setDateOfEssay(LocalDate dateOfEssay) {
        this.dateOfEssay = dateOfEssay;
    }

    public String getEssayDescription() {
        return essayDescription;
    }

    public void setEssayDescription(String essayDescription) {
        this.essayDescription = essayDescription;
    }

    public EquipmentForTestModel getEquipmentForTestModel() {
        return equipmentForTestModel;
    }

    public void setEquipmentForTestModel(EquipmentForTestModel equipmentForTestModel) {
        this.equipmentForTestModel = equipmentForTestModel;
    }

    public BatchInfo getBatchInfo() {
        return batchInfo;
    }

    public void setBatchInfo(BatchInfo batchInfo) {
        this.batchInfo = batchInfo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EssayModule getEssayModule() {
        return essayModule;
    }

    public void setEssayModule(EssayModule essayModule) {
        this.essayModule = essayModule;
    }

    public List<LabTestReport> getLabTestReportList() {
        return labTestReportList;
    }

    public void setLabTestReportList(List<LabTestReport> labTestReportList) {
        this.labTestReportList = labTestReportList;
    }

    @Override
    public String toString() {
        String equipmentForTestModelValue=null;
        String batchInfoValue=null;
        String employeeValue=null;
        String essayModuleValue=null;

        if (equipmentForTestModel==null){
            equipmentForTestModelValue="null";
        }else {
            equipmentForTestModelValue= equipmentForTestModel.toString();
        }
        if (batchInfo==null){
            batchInfoValue="null";
        }else {
            batchInfoValue= batchInfo.toString();
        }
        if (employee==null){
            employeeValue="null";
        }else {
            employeeValue= employee.toString();
        }
        if (essayModule==null){
            essayModuleValue="null";
        }else {
            essayModuleValue= essayModule.toString();
        }


        return "LabTestReport{" +
                "id=" + id +
                ", essayCode='" + essayCode + '\'' +
                ", dateOfEssay=" + dateOfEssay +
                ", essayDescription='" + essayDescription + '\'' +
                ", equipmentForTestModel=" + equipmentForTestModelValue +
                ", batchInfo=" +batchInfoValue+
                ", employee=" + employeeValue +
                ", essayModule=" + essayModuleValue +
                '}';
    }
}
