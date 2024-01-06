package com.solvd.essay;

import com.solvd.essay.domain.BatchInfo;
import com.solvd.essay.domain.EssayModule;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class EssayModuleHandler extends DefaultHandler {

    private String currentElement;
    private EssayModule essayModule= new EssayModule();

    private boolean moduleDescriptionObtainded =false;


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
        if(currentElement.equals("essayModule")){
            Long id=Long.valueOf(attributes.getValue("id"));
            essayModule.setId(id);
        }
        if (currentElement.equals("moduleDescription")){
            moduleDescriptionObtainded=true;
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
        if (moduleDescriptionObtainded){
            essayModule.setModuleDescription(value);
            moduleDescriptionObtainded=false;
        }
        //System.out.println(value);
    }

    public EssayModule getEssayModule() {
        return essayModule;
    }
}
