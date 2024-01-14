package com.solvd.essay.patterns.facadePattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LabVisitor implements  ObtainExternalPersonData<LabVisitor>{

    private static final Logger LOGGER = LogManager.getLogger(LabVisitor.class);
    private String firstName;
    private String lastName;
    private String personalId;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    @Override
    public String obtainExternalInfo(LabVisitor labVisitor) {
        String message=String.format("The name of the visitor is: %s, his last name is: %s," +
                " and his id: %s. Enjoy your visit in our lab",this.firstName,this.lastName,this.personalId);
        LOGGER.info(message);
        return message;
    }
}
