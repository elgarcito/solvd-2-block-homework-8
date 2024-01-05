package com.solvd.essay;

import com.solvd.essay.domain.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;

public class LabTestReportHandler extends DefaultHandler {

    private String currentElement;
    LabTestReport labTestReport =new LabTestReport();

    private EquipmentForTestModel equipmentForTestModel=new EquipmentForTestModel();
    private BatchInfo batchInfo=new BatchInfo();
    private Employee employee=new Employee();
    private EssayModule essayModule=new EssayModule();
    boolean essayCodeObtained=false;
    boolean dateOfEssayObtained=false;
    boolean essayDescriptionObtained=false;
    boolean equipmentForTestModelObtained=false;

    private boolean modelNameObtained =false;
    private boolean modelDescriptionObtained =false;
    private boolean releaseDateObtained =false;

    boolean batchInfoObtained=false;
    private boolean batchNumberObtainded =false;


    boolean employeeObtained=false;


    private boolean firstNameObtained =false;
    private boolean lastNameObtained =false;
    private boolean personalIdObtained =false;
    private boolean birthDateObtained =false;
    private boolean salaryObtained =false;
    boolean essayModuleObtained=false;
    private boolean moduleDescriptionObtainded =false;



    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("document start");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("document end");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        currentElement=qName;
        if(qName.equals("modelName")){
            Long id=1L;
        }
        //System.out.println(qName);

        if(currentElement.equals("labTestReport")){
            Long id=Long.valueOf(attributes.getValue("id"));
            labTestReport.setId(id);
        }
        if (currentElement.equals("essayCode")){
            essayCodeObtained=true;
        }
        if (currentElement.equals("dateOfEssay")){
            dateOfEssayObtained=true;
        }
        if (currentElement.equals("essayDescription")){
            essayDescriptionObtained=true;
        }
        if (currentElement.equals("equipmentForTestModel")){
            Long id=Long.valueOf(attributes.getValue("id"));
            equipmentForTestModel.setId(id);
            equipmentForTestModelObtained=true;
        }

        if (currentElement.equals("modelName")){
            modelNameObtained=true;
        }
        if (currentElement.equals("modelDescription")){
            modelDescriptionObtained=true;
        }
        if (currentElement.equals("releaseDate")){
            releaseDateObtained=true;
        }

        if (currentElement.equals("batchInfo")){
            Long id=Long.valueOf(attributes.getValue("id"));
            batchInfo.setId(id);
            batchInfoObtained=true;
        }

        if (currentElement.equals("batchNumber")){
            batchNumberObtainded=true;
        }

        if (currentElement.equals("employee")){
            Long id=Long.valueOf(attributes.getValue("id"));
            employee.setId(id);
            employeeObtained=true;
        }

        if (currentElement.equals("firstName")){
            firstNameObtained=true;
        }
        if (currentElement.equals("lastName")){
            lastNameObtained=true;
        }
        if (currentElement.equals("personalId")){
            personalIdObtained=true;
        }
        if (currentElement.equals("birthDate")){
            birthDateObtained=true;
        }
        if (currentElement.equals("salary")){
            salaryObtained=true;
        }

        if (currentElement.equals("essayModule")) {
            Long id=Long.valueOf(attributes.getValue("id"));
            essayModule.setId(id);
            essayModuleObtained = true;
        }

        if (currentElement.equals("moduleDescription")){
            moduleDescriptionObtainded=true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //System.out.println(qName);
        currentElement=null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value= new String(ch, start, length);
        if (currentElement!=null) {
            if (essayCodeObtained){
                labTestReport.setEssayCode(value);
                essayCodeObtained=false;
            }
            if(dateOfEssayObtained){
                labTestReport.setDateOfEssay(Date.valueOf(value));
                dateOfEssayObtained=false;
            }
            if(essayDescriptionObtained){
                labTestReport.setEssayDescription(value);
                essayDescriptionObtained=false;
            }
            if (currentElement.equals("modelName")) {
                equipmentForTestModel.setModelName(value);
                modelNameObtained=false;
            }
            if (currentElement.equals("modelDescription")) {
                equipmentForTestModel.setModelDescription(value);
                modelDescriptionObtained=false;
            }
            if (currentElement.equals("releaseDate")) {
                Date date= Date.valueOf(value);
                equipmentForTestModel.setReleaseDate(date);
                releaseDateObtained=false;
            }
            if (currentElement.equals("batchNumber")){
                batchInfo.setBatchNumber(value);
                batchNumberObtainded=false;
            }

            if (firstNameObtained){
                employee.setFirstName(value);
                firstNameObtained=false;
            }
            if (lastNameObtained){
                employee.setLastName(value);
                lastNameObtained=false;
            }
            if (personalIdObtained){
                employee.setPersonalId(value);
                personalIdObtained=false;
            }
            if (birthDateObtained){
                employee.setBirthDate(Date.valueOf(value));
                birthDateObtained=false;
            }
            if (salaryObtained){
                employee.setSalary(Double.valueOf(value));
                salaryObtained=false;
            }
            if (moduleDescriptionObtainded){
                essayModule.setModuleDescription(value);
                moduleDescriptionObtainded=false;
            }

        }


       // System.out.println(value);
    }

    public LabTestReport getLabTestReport(){
        labTestReport.setEquipmentForTestModel(equipmentForTestModel);
        labTestReport.setBatchInfo(batchInfo);
        labTestReport.setEmployee(employee);
        labTestReport.setEssayModule(essayModule);
        return labTestReport;
    }
}
