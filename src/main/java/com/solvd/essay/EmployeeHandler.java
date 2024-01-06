package com.solvd.essay;

import com.solvd.essay.domain.Employee;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;

public class EmployeeHandler extends DefaultHandler {

    private String currentElement;
    private Employee employee= new Employee();

    private boolean firstNameObtained =false;
    private boolean lastNameObtained =false;
    private boolean personalIdObtained =false;
    private boolean birthDateObtained =false;
    private boolean salaryObtained =false;


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
        if(currentElement.equals("employee")){
            Long id=Long.valueOf(attributes.getValue("id"));
            employee.setId(id);
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
    }

    public Employee getEmployee() {
        return employee;
    }
}
