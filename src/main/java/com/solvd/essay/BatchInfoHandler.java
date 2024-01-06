package com.solvd.essay;

import com.solvd.essay.domain.BatchInfo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class BatchInfoHandler extends DefaultHandler {

    private String currentElement;
    private BatchInfo batchInfo= new BatchInfo();

    private boolean batchNumberObtainded =false;


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
        if(currentElement.equals("batchInfo")){
            Long id=Long.valueOf(attributes.getValue("id"));
            batchInfo.setId(id);
        }
        if (currentElement.equals("batchNumber")){
            batchNumberObtainded=true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
       // System.out.println(qName);
        currentElement=null;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String value= new String(ch, start, length);
        if (batchNumberObtainded){
            batchInfo.setBatchNumber(value);
            batchNumberObtainded=false;
        }
        //System.out.println(value);
    }

    public BatchInfo getBatchInfo() {
        return batchInfo;
    }
}
