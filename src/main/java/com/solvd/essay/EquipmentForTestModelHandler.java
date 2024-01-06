package com.solvd.essay;

import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.domain.EquipmentForTestModel;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;
import java.time.LocalDate;

public class EquipmentForTestModelHandler extends DefaultHandler {

    private String currentElement;
    private EquipmentForTestModel equipmentForTestModel= new EquipmentForTestModel();

    private boolean modelNameObtained =false;
    private boolean modelDescriptionObtained =false;
    private boolean releaseDateObtained =false;


    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        //System.out.println("document start");
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
       // System.out.println("document end");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        currentElement=qName;
        //System.out.println(qName);
        if(currentElement.equals("equipmentForTestModel")){
            Long id=Long.valueOf(attributes.getValue("id"));
            equipmentForTestModel.setId(id);
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
        if (modelNameObtained){
            equipmentForTestModel.setModelName(value);
            modelNameObtained=false;
        }
        if (modelDescriptionObtained){
            equipmentForTestModel.setModelDescription(value);
            modelDescriptionObtained=false;
        }
        if (releaseDateObtained){
            LocalDate date= LocalDate.parse(value);
            equipmentForTestModel.setReleaseDate(date);
            releaseDateObtained=false;
        }
    }

    public EquipmentForTestModel getEquipmentForTestModel() {
        return equipmentForTestModel;
    }
}
