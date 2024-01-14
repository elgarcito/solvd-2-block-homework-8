package com.solvd.essay.patterns.facadePattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Client implements ObtainExternalPersonData<Client> {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);
    private String firstName;
    private String lastName;
    private String companyName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String obtainExternalInfo(Client client) {
        String message=String.format("The name of the client is: %s, his last name is: %s," +
                ". The company of this client is  %s.",this.firstName,this.lastName,this.companyName);
        LOGGER.info(message);
        return message;
    }
}
